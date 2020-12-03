// This sample demonstrates handling intents from an Alexa skill using the Alexa Skills Kit SDK (v2).
// Please visit https://alexa.design/cookbook for additional examples on implementing slots, dialog management,
// session persistence, api calls, and more.
const Alexa = require('ask-sdk-core');

const LaunchRequestHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'LaunchRequest';
    },
    handle(handlerInput) {
        const speakOutput = 'Welcome, you can say Hello or Help. Which would you like to try?';
        return handlerInput.responseBuilder
            .speak(speakOutput)
            .reprompt(speakOutput)
            .getResponse();
    }
};
const HelloWorldIntentHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && Alexa.getIntentName(handlerInput.requestEnvelope) === 'HelloWorldIntent';
    },
    handle(handlerInput) {
        const speakOutput = 'Hello Progressive Web Experience!';
        return handlerInput.responseBuilder
            .speak(speakOutput)
            //.reprompt('add a reprompt if you want to keep the session open for the user to respond')
            .getResponse();
    }
};

const DestinationInfoIntentHandler = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
        && Alexa.getIntentName(handlerInput.requestEnvelope) === 'DestinationInfoIntent';
  },
  handle(handlerInput) {
      // const destinationSlot = Alexa.getSlot(handlerInput.requestEnvelope, 'destination');
      // const destination = destinationSlot.resolutions.resolutionsPerAuthority[0].values[0].value.name;
      const destination = Alexa.getSlotValue(handlerInput.requestEnvelope, 'destination');
      // looked up info about the destination

      if ( supportsAPL(handlerInput) ) {
          console.log("D");
        handlerInput.responseBuilder.addDirective(
          {
            "type": "Alexa.Presentation.APL.RenderDocument",
            "token": "enjoyYourTrip",
            "document": {
                "type": "Link",
                "src": "doc://alexa/apl/documents/EnjoyYourTrip"
            },
            "datasources": {
                "tripData": {
                  "destination": destination
                }
            }
          }
        );
      }

      const speakOutput = `I hear that ${destination} is very nice at this time of year.`;
      return handlerInput.responseBuilder
          .speak(speakOutput)
          .getResponse();
  }
};

const ScheduleTripIntentHandler = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
        && Alexa.getIntentName(handlerInput.requestEnvelope) === 'ScheduleTripIntent';
  },
  handle(handlerInput) {
      // const destinationSlot = Alexa.getSlot(handlerInput.requestEnvelope, 'destination');
      // const destination = destinationSlot.resolutions.resolutionsPerAuthority[0].values[0].value.name;
      const destination = Alexa.getSlotValue(handlerInput.requestEnvelope, 'destination');
      const departureDate = Alexa.getSlotValue(handlerInput.requestEnvelope, 'departureDate');
      const returnDate = Alexa.getSlotValue(handlerInput.requestEnvelope, 'returnDate');


      // looked up info about the destination

      const speakOutput = `Enjoy your trip to ${destination}, between ${departureDate} and ${returnDate}!`;
      // const speakOutput = `<speak><audio src="soundbank://soundlibrary/telephones/modern_rings/modern_rings_02"/>Enjoy your trip....</speak>`;

      if ( supportsAPL(handlerInput) ) {
          console.log("D");
        handlerInput.responseBuilder.addDirective(
          {
            "type": "Alexa.Presentation.APL.RenderDocument",
            "token": "enjoyYourTrip",
            "document": require('./apl/EnjoyYourTrip.json'),
            "datasources": {
                "tripData": {
                  "destination": destination
                }
            }
          }
        );
      }

      return handlerInput.responseBuilder
          .speak(speakOutput)
          .getResponse();
  }
};


const supportsAPL = function(handlerInput) {
    console.log("A");
  const supportedInterfaces = handlerInput.requestEnvelope.context.System.device.supportedInterfaces;
  console.log("B");
  const aplInterface = supportedInterfaces['Alexa.Presentation.APL'];
  console.log("C");
  return aplInterface !== null && aplInterface !== undefined;
}

const SendEventHandler = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'Alexa.Presentation.APL.UserEvent';
  },
  handle(handlerInput) {
    const cityName = handlerInput.requestEnvelope.request.arguments[0];
    return handlerInput.responseBuilder
        .speak(`I love ${cityName}!`)
        .getResponse();
  }
};


const HelpIntentHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.HelpIntent';
    },
    handle(handlerInput) {
        const speakOutput = 'You can say hello to me! How can I help?';

        return handlerInput.responseBuilder
            .speak(speakOutput)
            .reprompt(speakOutput)
            .getResponse();
    }
};
const CancelAndStopIntentHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && (Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.CancelIntent'
                || Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.StopIntent');
    },
    handle(handlerInput) {
        const speakOutput = 'Goodbye!';
        return handlerInput.responseBuilder
            .speak(speakOutput)
            .getResponse();
    }
};
const SessionEndedRequestHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'SessionEndedRequest';
    },
    handle(handlerInput) {
        // Any cleanup logic goes here.
        return handlerInput.responseBuilder.getResponse();
    }
};

// The intent reflector is used for interaction model testing and debugging.
// It will simply repeat the intent the user said. You can create custom handlers
// for your intents by defining them above, then also adding them to the request
// handler chain below.
const IntentReflectorHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest';
    },
    handle(handlerInput) {
        const intentName = Alexa.getIntentName(handlerInput.requestEnvelope);
        const speakOutput = `You just triggered ${intentName}`;

        return handlerInput.responseBuilder
            .speak(speakOutput)
            //.reprompt('add a reprompt if you want to keep the session open for the user to respond')
            .getResponse();
    }
};

// Generic error handling to capture any syntax or routing errors. If you receive an error
// stating the request handler chain is not found, you have not implemented a handler for
// the intent being invoked or included it in the skill builder below.
const ErrorHandler = {
    canHandle() {
        return true;
    },
    handle(handlerInput, error) {
        console.log(`~~~~ Error handled: ${error.stack}`);
        const speakOutput = `Sorry, I had trouble doing what you asked. Please try again.`;

        return handlerInput.responseBuilder
            .speak(speakOutput)
            .reprompt(speakOutput)
            .getResponse();
    }
};

// The SkillBuilder acts as the entry point for your skill, routing all request and response
// payloads to the handlers above. Make sure any new handlers or interceptors you've
// defined are included below. The order matters - they're processed top to bottom.
exports.handler = Alexa.SkillBuilders.custom()
    .addRequestHandlers(
        LaunchRequestHandler,
        HelloWorldIntentHandler,
        DestinationInfoIntentHandler,
        ScheduleTripIntentHandler,
        SendEventHandler,
        HelpIntentHandler,
        CancelAndStopIntentHandler,
        SessionEndedRequestHandler,
        IntentReflectorHandler, // make sure IntentReflectorHandler is last so it doesn't override your custom intent handlers
    )
    .addErrorHandlers(
        ErrorHandler,
    )
    .lambda();
