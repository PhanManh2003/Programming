// firebaseConfig.js
import { initializeApp } from 'firebase/app';
import { getAuth } from 'firebase/auth';
import { getFirestore } from 'firebase/firestore';

const firebaseConfig = {
    apiKey: "AIzaSyCbF9tDOy3PQOX84Tj-PWQ1_w31fiZqvZw",
    authDomain: "fir-mma-a088f.firebaseapp.com",
    projectId: "fir-mma-a088f",
    storageBucket: "fir-mma-a088f.appspot.com",
    messagingSenderId: "330358675359",
    appId: "1:330358675359:android:529a17ee1bcb3c970c4faa"
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getFirestore(app);

export { auth, db };
