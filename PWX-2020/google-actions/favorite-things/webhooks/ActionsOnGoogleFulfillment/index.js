const { conversation, Card, Image } = require('@assistant/conversation');
const functions = require('firebase-functions');

const app = conversation();

app.handle('favoriteColorEvent', conv => {
  // Implement your code here
  console.log("LOGGING THE CONV:  ", conv);
  const favoriteColor = conv.scene.slots.favoriteColor.value;
  const favoritePet = conv.scene.slots.favoritePet.value;
  console.log("LOGGING A FAVORITE COLOR:  " + favoriteColor);
  conv.overwrite = true;
  conv.add(`A ${favoriteColor} ${favoritePet}! Imagine that!`);
   
  conv.add(new Card({
    title: 'Favorite Color',
    subtitle: 'The world is a carousel of colors...',
    text: `Your favorite color is ${favoriteColor}`,
    image: new Image({
      url: 'https://cdn4.iconfinder.com/data/icons/drawing-and-painting-tool-cartoon-style/512/al448_4-512.png',
      alt: 'colors'
    })
  }));
});

app.handle('WhatIsAPetIntentHandler', conv => {
  conv.add('A pet is a beloved animal that you treat as a close friend or a member of your family.');
});

exports.ActionsOnGoogleFulfillment = functions.https.onRequest(app);
