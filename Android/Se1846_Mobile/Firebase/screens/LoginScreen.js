import React, { useState } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet } from 'react-native';
import { auth, db } from './firebaseConfig.js';
import { signInWithEmailAndPassword, createUserWithEmailAndPassword } from 'firebase/auth';
import { doc, setDoc } from 'firebase/firestore';

export default function LoginScreen({ navigation }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSignUp = async () => {
    try {
      const userCredential = await createUserWithEmailAndPassword(auth, email, password);
      await setDoc(doc(db, 'users', userCredential.user.uid), {
        email,
        phone: '',
        address: '',
      });
      Alert.alert('Đăng ký thành công!');
    } catch (error) {
      Alert.alert('Lỗi', error.message);
    }
  };

  const handleLogin = async () => {
    try {
      await signInWithEmailAndPassword(auth, email, password);
      navigation.navigate('Profile');
    } catch (error) {
      Alert.alert('Lỗi', error.message);
    }
  };

  return (
    <View style={styles.container}>
      <Text>Email</Text>
      <TextInput value={email} onChangeText={setEmail} style={styles.input} />

      <Text>Password</Text>
      <TextInput value={password} onChangeText={setPassword} secureTextEntry style={styles.input} />

      <Button title="Đăng nhập" onPress={handleLogin} />
      <Button title="Đăng ký" onPress={handleSignUp} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, justifyContent: 'center' },
  input: { borderWidth: 1, padding: 8, marginVertical: 10, borderRadius: 5 }
});
