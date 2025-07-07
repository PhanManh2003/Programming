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
import React, { useState, useEffect } from "react";
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
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center", backgroundColor: "#fff" }}>
        <ActivityIndicator size="large" color="#007AFF" />
        <Text style={{ marginTop: 16, fontSize: 16, color: "#555" }}>Đang xử lý ảnh...</Text>
      </View>
    );


  if (selected) {
    return (
      <View style={{ flex: 1, backgroundColor: "#F9FAFB" }}>
        <Image
          source={{ uri: selected.uri }}
          style={{ width: "100%", height: 280, resizeMode: "cover" }}
        />

        <View
          style={{
            backgroundColor: "#fff",
            margin: 16,
            padding: 14,
            borderRadius: 10,
            shadowColor: "#000",
            shadowOpacity: 0.08,
            shadowOffset: { width: 0, height: 2 },
            shadowRadius: 6,
            elevation: 2,
          }}
        >
          <Text style={{ fontSize: 15, color: "#333", lineHeight: 22 }} selectable>
            {selected.description}
          </Text>
        </View>

        {Platform.OS !== "web" && (
          <MapView
            style={{ flex: 1, borderRadius: 10, marginHorizontal: 16, marginBottom: 16 }}
            region={{
              latitude: selected.location.latitude,
              longitude: selected.location.longitude,
              latitudeDelta: 0.004,
              longitudeDelta: 0.004,
            }}
          >
            <Marker coordinate={selected.location} />
          </MapView>
        )}

        <View style={{ marginHorizontal: 16, marginBottom: 20 }}>
          <Button title="🗑️ Xóa ảnh" color="crimson" onPress={() => deletePhoto(selected.id)} />
          <View style={{ marginTop: 10 }}>
            <Button title="🔙 Quay lại" onPress={() => setSelected(null)} />
          </View>
        </View>
      </View>
    );
  }


  return (
    <View style={{ flex: 1, paddingHorizontal: 16, paddingTop: 40, backgroundColor: "#f5f5f5" }}>
      <Button title="📸 Chụp ảnh mới" onPress={takePhoto} color="#007AFF" />

      <FlatList
        data={photos}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <TouchableOpacity onPress={() => setSelected(item)}>
            <View
              style={{
                flexDirection: "row",
                alignItems: "center",
                backgroundColor: "#fff",
                marginTop: 14,
                borderRadius: 10,
                padding: 10,
                shadowColor: "#000",
                shadowOpacity: 0.05,
                shadowRadius: 4,
                elevation: 1,
              }}
            >
              <Image
                source={{ uri: item.uri }}
                style={{ width: 70, height: 70, borderRadius: 8 }}
              />
              <View style={{ marginLeft: 12, flex: 1 }}>
                <Text numberOfLines={1} style={{ fontSize: 14, fontWeight: "500" }}>
                  {item.description}
                </Text>
                <Text style={{ fontSize: 12, color: "#777", marginTop: 4 }}>
                  {new Date(item.date).toLocaleString()}
                </Text>
              </View>
            </View>
          </TouchableOpacity>
        )}
        ListEmptyComponent={
          <Text style={{ textAlign: "center", marginTop: 50, color: "#999" }}>
            Bạn chưa có ảnh nào
          </Text>
        }
      />
    </View>
  );

}
