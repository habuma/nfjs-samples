const Alexa = require('ask-sdk-core');

exports.ScheduleTripIntentHandler = {
    canHandle(handlerInput) {
        console.log("IN CanHandle()");
        return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
            && Alexa.getIntentName(handlerInput.requestEnvelope) === 'ScheduleTripIntent';
    },
    handle(handlerInput) {
        const destination = getResolvedSlotValue(handlerInput.requestEnvelope, 'destination');
        const startDate = Alexa.getSlotValue(handlerInput.requestEnvelope, 'startDate');
        const tripLength = Alexa.getSlotValue(handlerInput.requestEnvelope, 'tripLength');

        // 
        // TODO: Submit trip details to backend travel system.
        //

        const speakOutput = `Enjoy your trip to ${destination}!`;

        return handlerInput.responseBuilder
            .speak(speakOutput)
            //.reprompt('add a reprompt if you want to keep the session open for the user to respond')
            .getResponse();
    }
};

const getResolvedSlotValue = (requestEnvelope, slotName) => {
    const slotResolution = Alexa.getSlot(requestEnvelope, slotName)
        .resolutions.resolutionsPerAuthority[0];

    return slotResolution.status.code === 'ER_SUCCESS_MATCH' ?
        slotResolution.values[0].value.name :
        Alexa.getSlotValue(requestEnvelope, slotName);
};