import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  TextInput,
  Pressable,
  FlatList,
  Alert,
  StyleSheet,
} from 'react-native';
import * as SQLite from 'expo-sqlite';

export default function App() {
  const [name, setName] = useState('');
  const [phone, setPhone] = useState('');
  const [contacts, setContacts] = useState([]);
  const [db, setDb] = useState(null);
  const [editingId, setEditingId] = useState(null); // ID đang được chỉnh sửa

  const loadDB = async () => {
    const database = await SQLite.openDatabaseAsync('contacts.db');
    setDb(database);
    await database.runAsync(
      'CREATE TABLE IF NOT EXISTS Contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, phone TEXT NOT NULL);'
    );
  };

  const fetchContacts = async () => {
    if (db) {
      const rows = await db.getAllAsync('SELECT * FROM Contacts');
      setContacts(rows.map(row => ({
        id: row.id,
        name: row.name,
        phone: row.phone,
      })));
    }
  };

  const addContact = async () => {
    if (!name.trim() || !phone.trim()) {
      Alert.alert('Vui lòng nhập tên và số điện thoại');
      return;
    }

    await db.runAsync('INSERT INTO Contacts (name, phone) VALUES (?, ?);', [name, phone]);
    setName('');
    setPhone('');
    fetchContacts();
  };

  const updateContact = async () => {
    if (!name.trim() || !phone.trim()) {
      Alert.alert('Vui lòng nhập tên và số điện thoại');
      return;
    }

    await db.runAsync('UPDATE Contacts SET name = ?, phone = ? WHERE id = ?;', [name, phone, editingId]);
    setName('');
    setPhone('');
    setEditingId(null);
    fetchContacts();
  };

  const deleteContact = async id => {
    await db.runAsync('DELETE FROM Contacts WHERE id = ?;', [id]);
    fetchContacts();
  };

  const editContact = (item) => {
    setName(item.name);
    setPhone(item.phone);
    setEditingId(item.id);
  };

  useEffect(() => {
    loadDB().then(() => fetchContacts());
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Danh bạ</Text>

      <TextInput
        style={styles.input}
        placeholder="Tên"
        value={name}
        onChangeText={setName}
      />

      <TextInput
        style={styles.input}
        placeholder="Số điện thoại"
        value={phone}
        onChangeText={setPhone}
        keyboardType="phone-pad"
      />

      {/* Nút Thêm hoặc Cập nhật */}
      <Pressable
        style={[styles.button, { backgroundColor: editingId ? 'orange' : 'green' }]}
        onPressIn={editingId ? updateContact : addContact}
      >
        <Text style={styles.buttonText}>{editingId ? 'Cập nhật' : 'Thêm liên hệ'}</Text>
      </Pressable>

      <FlatList
        data={contacts}
        keyExtractor={item => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.contactItem}>
            <Text>{item.name} - {item.phone}</Text>
            <View style={{ flexDirection: 'row' }}>
              <Pressable
                style={[styles.button, { backgroundColor: 'blue', marginRight: 5 }]}
                onPressIn={() => editContact(item)}
              >
                <Text style={styles.buttonText}>Sửa</Text>
              </Pressable>
              <Pressable
                style={[styles.button, { backgroundColor: 'red' }]}
                onPressIn={() => deleteContact(item.id)}
              >
                <Text style={styles.buttonText}>Xoá</Text>
              </Pressable>
            </View>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 24,
    textAlign: 'center',
    marginVertical: 20,
    fontWeight: 'bold',
  },
  input: {
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    marginBottom: 10,
    paddingHorizontal: 10,
    borderRadius: 5,
  },
  button: {
    paddingHorizontal: 12,
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: 'center',
    justifyContent: 'center',
    minWidth: 80,
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
  },
  contactItem: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: 12,
    backgroundColor: '#f1f1f1',
    marginTop: 10,
    borderRadius: 5,
  },
});
