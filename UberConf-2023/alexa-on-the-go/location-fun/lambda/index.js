/* *
 * This sample demonstrates handling intents from an Alexa skill using the Alexa Skills Kit SDK (v2).
 * Please visit https://alexa.design/cookbook for additional examples on implementing slots, dialog management,
 * session persistence, api calls, and more.
 * */
const Alexa = require('ask-sdk-core');
const axios = require('axios').default;

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

const WhereAmIIntentHandler = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
      && Alexa.getIntentName(handlerInput.requestEnvelope) === 'WhereAmIIntent';
  },
  async handle(handlerInput) {
    var speakOutput;
    const context = handlerInput.requestEnvelope.context;
    var isGeoSupported = context.System.device.supportedInterfaces.Geolocation;
    if ( isGeoSupported ) {
        if ( context.Geolocation && context.Geolocation.coordinate ) {
            const coordinates =  context.Geolocation.coordinate;
            const latitude = coordinates.latitudeInDegrees;
            const longitude = coordinates.longitudeInDegrees;

            const apiKey = require('./apikey.json').apiKey;
            const response = await axios.get(`https://api.geoapify.com/v1/geocode/reverse?lat=${latitude}&lon=${longitude}&format=json&apiKey=${apiKey}`);
            const data = response.data;
            const place = data.results[0]['address_line1'];
            speakOutput = `It appears that you are at ${place}.`;

        } else {
            speakOutput = 'I need to know where you are. Please enable location services in the Alexa app and then ask again.';
            // handlerInput
            //     .responseBuilder
            //         .withAskForPermissionsConsentCard(
            //             ['alexa::devices:all:geolocation:read']);

            handlerInput
                .responseBuilder
                    .addDirective({
                        'type': 'Connections.StartConnection',
                        'uri': 'connection://AMAZON.AskForPermissionsConsent/2',
                        'input': {
                            '@type': 'AskForPermissionsConsentRequest',
                            '@version': '2',
                            'permissionScopes': [
                                {
                                    'permissionScope': 'alexa::devices:all:geolocation:read',
                                    'consentLevel': 'ACCOUNT'
                                }
                            ]
                        },
                        'token': 'location-token'
                    });
        }
    } else {
        speakOutput = 'Your device does not support geo-location. ' +
                    'Please use a mobile device to ask about your location.';
    }
    return handlerInput.responseBuilder
      .speak(speakOutput)
      .getResponse();
  }
};

const SessionResumedRequestHandler = {
    canHandle(handlerInput) {
        const request = handlerInput.requestEnvelope.request;
        return request.type === 'SessionResumedRequest';
    },
    handle(handlerInput) {
        const connectionStatus = handlerInput.requestEnvelope.request.cause.status;
        const connectionsCode = connectionStatus.code;
        if ((connectionsCode != 200) && (connectionsCode != 204)) {
            return handlerInput
                .responseBuilder
                    .speak('Sorry, something went wrong. I am not sure what.')
                    .getResponse();
        }

        const voiceConsentStatus = handlerInput.requestEnvelope.request.cause.result.status;
        if (voiceConsentStatus === 'ACCEPTED') {
            return handlerInput.responseBuilder
                .speak('Thank you. Now ask about your location again.')
                .getResponse();
        }
        else {
            return handlerInput.responseBuilder
                .speak('To fulfill your request, I will need access to your location. Please see the Alexa app to grant permission.')
                .withAskForPermissionsConsentCard(['alexa::devices:all:geolocation:read'])
                .getResponse();
        }
    }
};

const HelloWorldIntentHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && Alexa.getIntentName(handlerInput.requestEnvelope) === 'HelloWorldIntent';
    },
    handle(handlerInput) {
        const speakOutput = 'Hello World!';

        return handlerInput.responseBuilder
            .speak(speakOutput)
            //.reprompt('add a reprompt if you want to keep the session open for the user to respond')
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
/* *
 * FallbackIntent triggers when a customer says something that doesn’t map to any intents in your skill
 * It must also be defined in the language model (if the locale supports it)
 * This handler can be safely added but will be ingnored in locales that do not support it yet 
 * */
const FallbackIntentHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.FallbackIntent';
    },
    handle(handlerInput) {
        const speakOutput = 'Sorry, I don\'t know about that. Please try again.';

        return handlerInput.responseBuilder
            .speak(speakOutput)
            .reprompt(speakOutput)
            .getResponse();
    }
};
/* *
 * SessionEndedRequest notifies that a session was ended. This handler will be triggered when a currently open 
 * session is closed for one of the following reasons: 1) The user says "exit" or "quit". 2) The user does not 
 * respond or says something that does not match an intent defined in your voice model. 3) An error occurs 
 * */
const SessionEndedRequestHandler = {
    canHandle(handlerInput) {
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'SessionEndedRequest';
    },
    handle(handlerInput) {
        console.log(`~~~~ Session ended: ${JSON.stringify(handlerInput.requestEnvelope)}`);
        // Any cleanup logic goes here.
        return handlerInput.responseBuilder.getResponse(); // notice we send an empty response
    }
};
/* *
 * The intent reflector is used for interaction model testing and debugging.
 * It will simply repeat the intent the user said. You can create custom handlers for your intents 
 * by defining them above, then also adding them to the request handler chain below 
 * */
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
/**
 * Generic error handling to capture any syntax or routing errors. If you receive an error
 * stating the request handler chain is not found, you have not implemented a handler for
 * the intent being invoked or included it in the skill builder below 
 * */
const ErrorHandler = {
    canHandle() {
        return true;
    },
    handle(handlerInput, error) {
        const speakOutput = 'Sorry, I had trouble doing what you asked. Please try again.';
        console.log(`~~~~ Error handled: ${JSON.stringify(error)}`);

        return handlerInput.responseBuilder
            .speak(speakOutput)
            .reprompt(speakOutput)
            .getResponse();
    }
};

const TestingRequestInterceptor = {
    process(handlerInput) {
        if (process.env.TEST_LOCATION) {
            const [latitude, longitude] = process.env.TEST_LOCATION.split(',');
            handlerInput.requestEnvelope.context.System.device.supportedInterfaces.Geolocation = {};

            handlerInput.requestEnvelope.context.System
                .user.permissions.scopes['alexa::devices:all:geolocation:read'].status = 'GRANTED';

             handlerInput.requestEnvelope.context.Geolocation = {};
             handlerInput.requestEnvelope.context.Geolocation.coordinate = {};
             handlerInput.requestEnvelope.context.Geolocation.coordinate.latitudeInDegrees = latitude;
             handlerInput.requestEnvelope.context.Geolocation.coordinate.longitudeInDegrees = longitude;
        }
    }
};

/**
 * This handler acts as the entry point for your skill, routing all request and response
 * payloads to the handlers above. Make sure any new handlers or interceptors you've
 * defined are included below. The order matters - they're processed top to bottom 
 * */
exports.handler = Alexa.SkillBuilders.custom()
    .addRequestHandlers(
        LaunchRequestHandler,
        HelloWorldIntentHandler,
        WhereAmIIntentHandler,
        SessionResumedRequestHandler,
        HelpIntentHandler,
        CancelAndStopIntentHandler,
        FallbackIntentHandler,
        SessionEndedRequestHandler,
        IntentReflectorHandler)
    .addErrorHandlers(
        ErrorHandler)
    .addRequestInterceptors(
        TestingRequestInterceptor)
    .withCustomUserAgent('sample/hello-world/v1.2')
    .lambda();