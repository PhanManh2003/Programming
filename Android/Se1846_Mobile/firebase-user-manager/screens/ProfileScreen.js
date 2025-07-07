import React, { useState, useEffect } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { auth, db } from '../firebaseConfig';
import { signOut, updateEmail, updatePassword } from 'firebase/auth';
import { doc, getDoc, setDoc } from 'firebase/firestore';

export default function ProfileScreen({ navigation }) {
    const user = auth.currentUser;
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');

    useEffect(() => {
        const loadData = async () => {
            if (user) {
                const ref = doc(db, 'users', user.uid);
                const snap = await getDoc(ref);
                if (snap.exists()) {
                    const data = snap.data();
                    setPhone(data.phone || '');
                    setAddress(data.address || '');
                }
            }
        };
        loadData();
    }, [user]);

    const handleSave = async () => {
        if (user) {
            await setDoc(doc(db, 'users', user.uid), { phone, address });
            alert('Đã lưu thông tin!');
        }
    };

    const handleEmailChange = async () => {
        const newEmail = prompt('Email mới:');
        await updateEmail(user, newEmail);
        alert('Email đã đổi!');
    };

    const handlePasswordChange = async () => {
        const newPass = prompt('Mật khẩu mới:');
        await updatePassword(user, newPass);
        alert('Mật khẩu đã đổi!');
    };

    return (
        <View style={styles.container}>
            <Text>Email: {user?.email}</Text>
            <TextInput value={phone} onChangeText={setPhone} placeholder="Số điện thoại" style={styles.input} />
            <TextInput value={address} onChangeText={setAddress} placeholder="Địa chỉ" style={styles.input} />
            <Button title="Lưu thông tin" onPress={handleSave} />
            <Button title="Đổi Email" onPress={handleEmailChange} />
            <Button title="Đổi mật khẩu" onPress={handlePasswordChange} />
            <Button title="Đăng xuất" onPress={() => { signOut(auth); navigation.navigate('Auth'); }} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: { flex: 1, justifyContent: 'center', padding: 20 },
    input: { borderWidth: 1, padding: 10, marginBottom: 10, borderRadius: 5 }
});
