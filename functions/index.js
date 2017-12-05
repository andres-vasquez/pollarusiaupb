const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);
var db = admin.firestore();

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });

exports.guardarEnBaseDatos = functions.auth.user().onCreate(event => {

    const user = event.data;

    const email = user.email;
    const displayName = user.displayName ? user.displayName : "";

    console.log('Se esta creando el usuario: ' + email);

    var ref = db.collection('users').doc(user.uid)

    return ref.set({
          email: email,
          displayName: displayName,
          genero: 'Femenino'
        });
});
