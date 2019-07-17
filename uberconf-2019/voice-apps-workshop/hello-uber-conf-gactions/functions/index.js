const {actionssdk} = require ('actions-on-google');
const functions = require('firebase-functions');
const app = actionssdk({debug: true});

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });

app.intent('actions.intent.MAIN', (conv) => {
    conv.ask('Welcome to Uber Conf. You can say hi.');
});

app.intent('com.habuma.hello.HITHERE', (conv) => {
    conv.close('Hi there!');
});

exports.uberConf = functions.https.onRequest(app);
