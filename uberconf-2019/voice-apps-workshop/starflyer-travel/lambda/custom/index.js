/* eslint-disable  func-names */
/* eslint-disable  no-console */

const Alexa = require('ask-sdk-core');
const request = require('request');
const {DynamoDbPersistenceAdapter} = require ('ask-sdk-dynamodb-persistence-adapter');
const persistenceAdapter = new DynamoDbPersistenceAdapter(
  {
    tableName: 'RememberWhereIWent',
    createTable: true
  }
);


const PERMISSIONS = ['alexa::profile:given_name:read', 'alexa::profile:email:read'];
const LaunchRequestHandler = {
  canHandle(handlerInput) {
    return handlerInput.requestEnvelope.request.type === 'LaunchRequest';
  },
  async handle(handlerInput) {

    const { requestEnvelope, serviceClientFactory, responseBuilder} = handlerInput;

    try {
      const client = serviceClientFactory.getUpsServiceClient();
      const email = await client.getProfileEmail();
      const givenName = await client.getProfileGivenName();
      console.log("GOT PROFILE DATA : ", email, givenName);
    } catch (error) {
      if (error.name === 'ServiceError' && error.statusCode == 403) {
        return responseBuilder
            .speak("Please grant me permission to access your email address and name in the Amazon Alexa app.")
            .withAskForPermissionsConsentCard(PERMISSIONS)
            .getResponse();
      }
      throw error;
    }

    const speechText = 'Welcome to StarFlyer Travel. Where do you want to go?';

    return responseBuilder
      .speak(speechText)
      .reprompt(speechText)
      .withSimpleCard('Hello World', speechText)
      .addDirective({
        type: 'Alexa.Presentation.APL.RenderDocument',
        version: '1.0',
        document: require('stoplight.json'),
        datasources: {
          "welcomeData": {
            "welcomeText": speechText
          }
        }
      })
      .getResponse();
  },
};

const HelloWorldIntentHandler = {
  canHandle(handlerInput) {
    return handlerInput.requestEnvelope.request.type === 'IntentRequest'
      && handlerInput.requestEnvelope.request.intent.name === 'HelloWorldIntent';
  },
  handle(handlerInput) {
    const speechText = 'Hello traveler!';
    console.log('Saying hello...');
    console.log(handlerInput);

    return handlerInput.responseBuilder
      .speak(speechText)
      .withSimpleCard('StarFlyer Travel', speechText)
      .getResponse();
  },
};

const ScheduleTripIntentHandler = {
  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;

    return request.type === 'IntentRequest'
      && request.intent.name === 'ScheduleTripIntent'
      && (request.dialogState === 'COMPLETED');

  },
  async handle(handlerInput) {

    const { requestEnvelope, serviceClientFactory, responseBuilder} = handlerInput;

    try {
      const client = serviceClientFactory.getUpsServiceClient();
      const email = await client.getProfileEmail();
      const givenName = await client.getProfileGivenName();
      console.log("GOT PROFILE DATA : ", email, givenName);

      const allSlots = handlerInput.requestEnvelope.request.intent.slots;
      // const destination = allSlots['destination'].value;
      const destination = allSlots['destination']
          .resolutions.resolutionsPerAuthority[0].values[0].value.name;


      handlerInput.attributesManager.getPersistentAttributes()
        .then((attributes) => {
          if (attributes.previousDestination.destination) {
            console.log("I remember that your previous destination was " + attributes.previousDestination.destination);
          }
          attributes.previousDestination = {
            'destination': destination
          };
          handlerInput.attributesManager.setPersistentAttributes(attributes);
          handlerInput.attributesManager.savePersistentAttributes();
          console.log("I'll remember that your destination is " + destination);
        });


      const departureDate = allSlots['departureDate'].value;
      const returnDate = allSlots['returnDate'].value;


      var accessToken = handlerInput.requestEnvelope.context.System.user.accessToken;
      if (accessToken == undefined) {
        const speechText = "You must have a skill that is connected to your Google Calendar account. " +
                "Please use Alexa app to link your Alexa account to Google.";

        return responseBuilder
            .speak(speechText)
            .withLinkAccountCard()
            .getResponse();
      }

      const summary = `Trip to ${destination}`;
      const description = `Trip to ${destination} leaving ${departureDate} and returning ${returnDate}. Pack your bags.`

      await addToGoogleCalendar(accessToken, summary, description, departureDate, returnDate);
      const speechText = `Enjoy your trip to ${destination}, ${givenName}! Thanks for using StarFlyer Travel.`;

      return handlerInput.responseBuilder
        .speak(speechText)
        .withSimpleCard('StarFlyer Travel', speechText)
        .withShouldEndSession(true)
        .getResponse();

    } catch (error) {
      if (error.name === 'ServiceError' && error.statusCode == 403) {
        return responseBuilder
            .speak("Please grant me permission to access your email address and name in the Amazon Alexa app.")
            .withAskForPermissionsConsentCard(PERMISSIONS)
            .getResponse();
      }
      throw error;
    }
  },
};

function addToGoogleCalendar(token, summary, description, departureDate, returnDate) {
  return new Promise((resolve, reject) => {
    const payload = {
      summary: summary,
      description: description,
      "end": { date: returnDate },
      start: { date: departureDate }
    };

    request(
      {
        method: 'POST',
        uri: 'https://www.googleapis.com/calendar/v3/calendars/primary/events',
        headers: {
          'Accept': 'application/json',
          'Content-type': 'application/json',
          'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify(payload)
      }, function (err, res, body) {
        return resolve(JSON.parse(body));
      }
    );
  });
}

const ScheduleTripIntentHandler_InProgress = {
  canHandle(handlerInput) {
    const request = handlerInput.requestEnvelope.request;
    return request.type === 'IntentRequest'
      && request.intent.name === 'ScheduleTripIntent'
      && (request.dialogState === 'STARTED' || request.dialogState === 'IN_PROGRESS');
  },
  handle(handlerInput) {
    const currentIntent = handlerInput.requestEnvelope.request.intent;
    const allSlots = currentIntent.slots;
    const departureString = allSlots['departureDate'].value;
    const returnString = allSlots['returnDate'].value;

    if (departureString && returnString) {
      const departureDate = new Date(departureString);
      const returnDate = new Date(returnString);
      if (departureDate >= returnDate) {
        currentIntent.slots['returnDate'].value = null;
        return handlerInput.responseBuilder
          .speak("StarFlyer Travel specializes in space travel, \
              not time travel. Please specify a return date that is \
              after the departure date.")
          .addDelegateDirective(currentIntent)
          .getResponse();
      }
    }

    return handlerInput.responseBuilder
        .addDelegateDirective(currentIntent)
        .getResponse();
  },
};

const HelpIntentHandler = {
  canHandle(handlerInput) {
    return handlerInput.requestEnvelope.request.type === 'IntentRequest'
      && handlerInput.requestEnvelope.request.intent.name === 'AMAZON.HelpIntent';
  },
  handle(handlerInput) {
    const speechText = 'You can say hello to me!';

    return handlerInput.responseBuilder
      .speak(speechText)
      .reprompt(speechText)
      .withSimpleCard('Hello World', speechText)
      .getResponse();
  },
};

const CancelAndStopIntentHandler = {
  canHandle(handlerInput) {
    return handlerInput.requestEnvelope.request.type === 'IntentRequest'
      && (handlerInput.requestEnvelope.request.intent.name === 'AMAZON.CancelIntent'
        || handlerInput.requestEnvelope.request.intent.name === 'AMAZON.StopIntent');
  },
  handle(handlerInput) {
    const speechText = 'Goodbye!';

    return handlerInput.responseBuilder
      .speak(speechText)
      .withSimpleCard('Hello World', speechText)
      .getResponse();
  },
};

const SessionEndedRequestHandler = {
  canHandle(handlerInput) {
    return handlerInput.requestEnvelope.request.type === 'SessionEndedRequest';
  },
  handle(handlerInput) {
    console.log(`Session ended with reason: ${handlerInput.requestEnvelope.request.reason}`);

    return handlerInput.responseBuilder.getResponse();
  },
};

const ErrorHandler = {
  canHandle() {
    return true;
  },
  handle(handlerInput, error) {
    console.log(`Error handled: ${error.message}`);

    return handlerInput.responseBuilder
      .speak('Sorry, I can\'t understand the command. Please say again.')
      .reprompt('Sorry, I can\'t understand the command. Please say again.')
      .getResponse();
  },
};

const skillBuilder = Alexa.SkillBuilders.custom();

exports.handler = skillBuilder
  .addRequestHandlers(
    LaunchRequestHandler,
    HelloWorldIntentHandler,
    ScheduleTripIntentHandler,
    ScheduleTripIntentHandler_InProgress,
    HelpIntentHandler,
    CancelAndStopIntentHandler,
    SessionEndedRequestHandler
  )
  .withApiClient(new Alexa.DefaultApiClient())
  .withPersistenceAdapter(persistenceAdapter)
  .addErrorHandlers(ErrorHandler)
  .lambda();
