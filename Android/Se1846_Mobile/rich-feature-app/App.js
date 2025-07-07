// // App.js
// import React from 'react';
// import { NavigationContainer } from '@react-navigation/native';
// import { createStackNavigator } from '@react-navigation/stack';
// import HomeScreen from './screens/HomeScreen';
// import PhotoDetailScreen from './screens/PhotoDetailScreen';

// const Stack = createStackNavigator();

// export default function App() {
//   return (
//     <NavigationContainer>
//       <Stack.Navigator>
//         <Stack.Screen name="Home" component={HomeScreen} />
//         <Stack.Screen name="PhotoDetail" component={PhotoDetailScreen} />
//       </Stack.Navigator>
//     </NavigationContainer>
//   );
// }

// // import React, { useState, useEffect } from 'react';
// // import {
// //   View,
// //   Text,
// //   Button,
// //   Image,
// //   FlatList,
// //   TouchableOpacity,
// //   StyleSheet,
// //   Alert,
// // } from 'react-native';
// // import { launchCamera } from 'react-native-image-picker';
// // import AsyncStorage from '@react-native-async-storage/async-storage';
// // import MapView, { Marker } from 'react-native-maps';
// // import Geolocation from 'react-native-geolocation-service';

// // const GEMINI_API_KEY = 'AIzaSyBltmpWYoRA_2EdB_pVzOPiIaph35EsBo8';

// // const App = () => {
// //   const [photos, setPhotos] = useState([]);

// //   useEffect(() => {
// //     loadPhotos();
// //   }, []);

// //   const loadPhotos = async () => {
// //     const saved = await AsyncStorage.getItem('photos');
// //     if (saved) setPhotos(JSON.parse(saved));
// //   };

// //   const savePhotos = async (newPhotos) => {
// //     await AsyncStorage.setItem('photos', JSON.stringify(newPhotos));
// //   };

// //   const generateDescription = async (base64Image) => {
// //     const response = await fetch(
// //       `https://generativelanguage.googleapis.com/v1beta/models/gemini-pro-vision:generateContent?key=${GEMINI_API_KEY}`,
// //       {
// //         method: 'POST',
// //         headers: { 'Content-Type': 'application/json' },
// //         body: JSON.stringify({
// //           contents: [
// //             {
// //               parts: [
// //                 { inlineData: { mimeType: 'image/jpeg', data: base64Image } },
// //                 { text: 'Hãy mô tả hình ảnh này bằng tiếng Việt.' },
// //               ],
// //             },
// //           ],
// //         }),
// //       }
// //     );
// //     const data = await response.json();
// //     return data?.candidates?.[0]?.content?.parts?.[0]?.text || 'Không có mô tả';
// //   };

// //   const handleTakePhoto = () => {
// //     launchCamera({ mediaType: 'photo', includeBase64: true }, async (res) => {
// //       if (res.assets && res.assets.length > 0) {
// //         const image = res.assets[0];
// //         Geolocation.getCurrentPosition(
// //           async (position) => {
// //             const description = await generateDescription(image.base64);
// //             const newPhoto = {
// //               uri: image.uri,
// //               base64: image.base64,
// //               latitude: position.coords.latitude,
// //               longitude: position.coords.longitude,
// //               description,
// //               timestamp: Date.now(),
// //             };
// //             const updatedPhotos = [newPhoto, ...photos];
// //             setPhotos(updatedPhotos);
// //             await savePhotos(updatedPhotos);
// //           },
// //           (error) => {
// //             Alert.alert('Lỗi GPS', 'Không lấy được vị trí');
// //           },
// //           { enableHighAccuracy: true, timeout: 15000 }
// //         );
// //       }
// //     });
// //   };

// //   const deletePhoto = async (timestamp) => {
// //     const updated = photos.filter((p) => p.timestamp !== timestamp);
// //     setPhotos(updated);
// //     await savePhotos(updated);
// //   };

// //   const renderPhoto = ({ item }) => (
// //     <View style={styles.photoContainer}>
// //       <Image source={{ uri: item.uri }} style={styles.image} />
// //       <Text>{item.description}</Text>
// //       <MapView
// //         style={styles.map}
// //         region={{
// //           latitude: item.latitude,
// //           longitude: item.longitude,
// //           latitudeDelta: 0.01,
// //           longitudeDelta: 0.01,
// //         }}
// //       >
// //         <Marker coordinate={{ latitude: item.latitude, longitude: item.longitude }} />
// //       </MapView>
// //       <TouchableOpacity onPress={() => deletePhoto(item.timestamp)} style={styles.deleteButton}>
// //         <Text style={styles.deleteText}>Xoá</Text>
// //       </TouchableOpacity>
// //     </View>
// //   );

// //   return (
// //     <View style={styles.container}>
// //       <Button title="Chụp ảnh" onPress={handleTakePhoto} />
// //       <FlatList
// //         data={photos}
// //         keyExtractor={(item) => item.timestamp.toString()}
// //         renderItem={renderPhoto}
// //       />
// //     </View>
// //   );
// // };

// // export default App;

// // const styles = StyleSheet.create({
// //   container: { flex: 1, paddingTop: 50 },
// //   photoContainer: {
// //     marginVertical: 10,
// //     padding: 10,
// //     borderBottomWidth: 1,
// //     borderColor: '#ccc',
// //   },
// //   image: { width: '100%', height: 200, borderRadius: 8 },
// //   map: { height: 150, marginTop: 10, borderRadius: 8 },
// //   deleteButton: {
// //     marginTop: 10,
// //     backgroundColor: 'red',
// //     padding: 8,
// //     borderRadius: 6,
// //     alignItems: 'center',
// //   },
// //   deleteText: { color: 'white', fontWeight: 'bold' },
// // });
import {
  View,
  Text,
  Button,
  Image,
  FlatList,
  TouchableOpacity,
  Alert,
  Platform,
  ActivityIndicator,
} from "react-native";
import * as ImagePicker from "expo-image-picker";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { v4 as uuidv4 } from "uuid";
import MapView, { Marker } from "react-native-maps";
import * as Location from "expo-location";

const GEMINI_API_KEY = "AIzaSyBltmpWYoRA_2EdB_pVzOPiIaph35EsBo8"; // Replace with your Gemini key

export default function App() {
  const [photos, setPhotos] = useState([]);
  const [selected, setSelected] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    loadPhotos();
  }, []);

  async function loadPhotos() {
    try {
      const data = await AsyncStorage.getItem("PHOTOS");
      if (data) setPhotos(JSON.parse(data));
      else setPhotos([]);
    } catch (e) {
      Alert.alert("Error", "Unable to read photo data");
    }
  }

  async function savePhotos(newPhotos) {
    try {
      await AsyncStorage.setItem("PHOTOS", JSON.stringify(newPhotos));
      setPhotos(newPhotos);
    } catch (e) {
      Alert.alert("Error", "Unable to save photo");
    }
  }

  async function takePhoto() {
    const { status: cameraStatus } =
      await ImagePicker.requestCameraPermissionsAsync();
    if (cameraStatus !== "granted") {
      Alert.alert("Permission denied", "Camera access is required");
      return;
    }

    const { status: mediaStatus } =
      await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (mediaStatus !== "granted") {
      Alert.alert("Permission denied", "Media library access is required");
      return;
    }

    const { status: locationStatus } =
      await Location.requestForegroundPermissionsAsync();
    if (locationStatus !== "granted") {
      Alert.alert("Permission denied", "Location access is required to save photo location");
      return;
    }

    let result = await ImagePicker.launchCameraAsync({
      base64: true,
      quality: 0.7,
    });

    console.log("ImagePicker result:", result);

    if (!result || result.canceled || !result.assets || !result.assets[0]) {
      Alert.alert("No photo captured!");
      return;
    }

    setLoading(true);
    try {
      let asset = result.assets[0];
      let loc = await Location.getCurrentPositionAsync({});
      let desc = "No description";

      if (GEMINI_API_KEY && GEMINI_API_KEY !== "YOUR_GEMINI_API_KEY") {
        desc = await getDescription(asset.base64);
      }

      console.log("URI:", asset.uri);
      console.log("Location:", loc.coords);
      console.log("Description:", desc);

      const photoObj = {
        id: uuidv4(),
        uri: asset.uri,
        location: {
          latitude: loc.coords.latitude,
          longitude: loc.coords.longitude,
        },
        description: desc,
        date: new Date().toISOString(),
      };

      const newPhotos = [photoObj, ...photos];
      await savePhotos(newPhotos);
      Alert.alert("Success", "Photo saved!");
    } catch (err) {
      Alert.alert("Error", "Could not take/save photo! Details: " + err?.message);
      console.log("Error details:", err);
    } finally {
      setLoading(false);
      await loadPhotos();
    }
  }

  async function getDescription(base64img) {
    try {
      const res = await fetch(
        `https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent?key=${GEMINI_API_KEY}`,
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            contents: [
              {
                parts: [
                  {
                    inline_data: { mime_type: "image/jpeg", data: base64img },
                  },
                ],
              },
            ],
          }),
        }
      );
      const data = await res.json();
      console.log("Gemini API Response:", JSON.stringify(data, null, 2));
      return (
        data?.candidates?.[0]?.content?.parts?.[0]?.text || "No description"
      );
    } catch (e) {
      console.log("AI Error:", e);
      return "AI Error";
    }
  }

  async function deletePhoto(id) {
    Alert.alert("Delete photo?", "Are you sure you want to delete this photo?", [
      { text: "Cancel", style: "cancel" },
      {
        text: "Delete",
        style: "destructive",
        onPress: async () => {
          const newPhotos = photos.filter((p) => p.id !== id);
          await savePhotos(newPhotos);
          setSelected(null);
        },
      },
    ]);
  }

  if (loading)
    return (
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <ActivityIndicator size="large" color="#007AFF" />
        <Text style={{ marginTop: 20 }}>Processing photo...</Text>
      </View>
    );

  if (selected) {
    return (
      <View style={{ flex: 1, backgroundColor: "#f2f2f2" }}>
        <Image
          source={{ uri: selected.uri }}
          style={{ width: "100%", height: 300 }}
        />
        <View
          style={{
            backgroundColor: "#fff",
            marginHorizontal: 14,
            marginTop: 10,
            marginBottom: 8,
            borderRadius: 12,
            padding: 16,
            minHeight: 60,
            maxHeight: 260,
            shadowColor: "#000",
            shadowOpacity: 0.12,
            shadowRadius: 8,
            elevation: 2,
            justifyContent: "center",
            alignItems: "flex-start",
          }}
        >
          <Text
            style={{
              color: "#191919",
              fontSize: 16,
              fontWeight: "500",
            }}
            selectable
          >
            {selected.description}
          </Text>
        </View>
        {Platform.OS !== "web" && (
          <MapView
            style={{ flex: 1, minHeight: 200 }}
            region={{
              latitude: selected.location.latitude,
              longitude: selected.location.longitude,
              latitudeDelta: 0.005,
              longitudeDelta: 0.005,
            }}
          >
            <Marker coordinate={selected.location} />
          </MapView>
        )}
        <Button
          title="Delete Photo"
          color="red"
          onPress={() => deletePhoto(selected.id)}
        />
        <Button title="Back" onPress={() => setSelected(null)} />
      </View>
    );
  }

  return (
    <View style={{ flex: 1, padding: 10, marginTop: 30 }}>
      <Button title="Take a Photo" onPress={takePhoto} />
      <FlatList
        data={photos}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <TouchableOpacity onPress={() => setSelected(item)}>
            <View
              style={{
                flexDirection: "row",
                marginVertical: 8,
                alignItems: "center",
              }}
            >
              <Image
                source={{ uri: item.uri }}
                style={{ width: 80, height: 80, borderRadius: 8 }}
              />
              <View style={{ marginLeft: 10, flex: 1 }}>
                <Text numberOfLines={1}>{item.description}</Text>
                <Text style={{ fontSize: 12, color: "gray" }}>
                  {new Date(item.date).toLocaleString()}
                </Text>
              </View>
            </View>
          </TouchableOpacity>
        )}
        ListEmptyComponent={
          <Text style={{ textAlign: "center", marginTop: 40 }}>
            No photos yet
          </Text>
        }
      />
    </View>
  );
}
