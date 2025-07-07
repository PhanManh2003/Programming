import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { createUserWithEmailAndPassword, signInWithEmailAndPassword } from 'firebase/auth';
import { auth } from '../firebaseConfig';

export default function AuthScreen({ navigation }) {
  const [isRegister, setIsRegister] = useState(true);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async () => {
    try {
      if (isRegister) {
        await createUserWithEmailAndPassword(auth, email, password);
        alert('Đăng ký thành công');
      } else {
        await signInWithEmailAndPassword(auth, email, password);
        alert('Đăng nhập thành công');
        navigation.navigate('Profile');
      }
    } catch (err) {
      alert(err.message);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{isRegister ? 'Đăng ký' : 'Đăng nhập'}</Text>
      <TextInput
        placeholder="Email"
        value={email}
        onChangeText={setEmail}
        style={styles.input}
      />
      <TextInput
        placeholder="Mật khẩu"
        value={password}
        onChangeText={setPassword}
        secureTextEntry
        style={styles.input}
      />
      <Button title={isRegister ? 'Đăng ký' : 'Đăng nhập'} onPress={handleSubmit} />
      <Button
        title={isRegister ? 'Chuyển sang đăng nhập' : 'Chuyển sang đăng ký'}
        onPress={() => setIsRegister(!isRegister)}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', padding: 20 },
  title: { fontSize: 24, marginBottom: 20, textAlign: 'center' },
  input: { borderWidth: 1, padding: 10, marginBottom: 10, borderRadius: 5 }
});
