const Alexa = require('ask-sdk-core');
const util = require('./util');

const ScheduleTripApiHandler = {
    canHandle(handlerInput) {
        return util.isApiRequest(
            handlerInput, 'com.ubertravel.scheduleTrip');
    },
    handle(handlerInput) {
        const destination = util.getApiArguments(handlerInput).destination;
        const startDate = util.getApiArguments(handlerInput).startDate;
        const tripLength = util.getApiArguments(handlerInput).tripLength;

        const reservationNumber = 
            scheduleTrip(destination, startDate, tripLength);

        const response = {
            apiResponse: {
                reservationNumber: reservationNumber,
                destination: destination,
                departureDate: startDate,
                returnDate: tripLength
            }
        };

        return response;
    }
};

function scheduleTrip(destination, departureDate, returnDate) {
    console.log("HANDLING A SCHEDULE TRIP REQUEST::::: ");
    console.log(`  -  ${destination}`);
    console.log(`  -  ${departureDate}`);
    console.log(`  -  ${returnDate}`);

    //
    // TODO: Invoke travel booking API
    //

    return 12345; // <-- Fake reservation number
}

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
        ScheduleTripApiHandler,
        SessionEndedRequestHandler,
        IntentReflectorHandler,
    )
    .addErrorHandlers(
        ErrorHandler,
    )
    .lambda();
