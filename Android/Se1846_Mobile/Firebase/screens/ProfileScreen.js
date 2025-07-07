import React, { useState, useEffect } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet } from 'react-native';
import { auth, db } from './firebaseConfig';
import { signOut, updateEmail, updatePassword } from 'firebase/auth';
import { doc, getDoc, updateDoc } from 'firebase/firestore';

export default function ProfileScreen({ navigation }) {
    const user = auth.currentUser;
    const [email, setEmail] = useState(user?.email || '');
    const [password, setPassword] = useState('');
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            const docRef = doc(db, 'users', user.uid);
            const docSnap = await getDoc(docRef);
            if (docSnap.exists()) {
                const data = docSnap.data();
                setPhone(data.phone);
                setAddress(data.address);
            }
        };
        fetchData();
    }, []);

    const handleSave = async () => {
        try {
            // Update email
            if (email !== user.email) {
                await updateEmail(user, email);
            }
            // Update password
            if (password) {
                await updatePassword(user, password);
            }
            // Update Firestore
            await updateDoc(doc(db, 'users', user.uid), {
                phone,
                address
            });
            Alert.alert('Cập nhật thành công!');
        } catch (error) {
            Alert.alert('Lỗi', error.message);
        }
    };

    const handleLogout = async () => {
        await signOut(auth);
        navigation.navigate('Login');
    };

    return (
        <View style={styles.container}>
            <Text>Email</Text>
            <TextInput value={email} onChangeText={setEmail} style={styles.input} />

            <Text>New Password</Text>
            <TextInput value={password} onChangeText={setPassword} secureTextEntry style={styles.input} />

            <Text>Phone</Text>
            <TextInput value={phone} onChangeText={setPhone} style={styles.input} />

            <Text>Address</Text>
            <TextInput value={address} onChangeText={setAddress} style={styles.input} />

            <Button title="Save" onPress={handleSave} />
            <Button title="Logout" onPress={handleLogout} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: { flex: 1, padding: 20 },
    input: { borderWidth: 1, padding: 8, marginVertical: 10, borderRadius: 5 }
});
