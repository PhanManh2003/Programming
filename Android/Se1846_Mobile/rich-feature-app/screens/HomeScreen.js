// screens/HomeScreen.js

// Import React và các hook
import React, { useEffect, useState } from 'react';

// Import các component UI từ React Native
import {
    View,
    FlatList,
    Button,
    Image,
    Text,
    TouchableOpacity,
    Alert,
    StyleSheet
} from 'react-native';

// Import Expo Image Picker để chụp ảnh
import * as ImagePicker from 'expo-image-picker';

// Import Expo Location để lấy toạ độ GPS
import * as Location from 'expo-location';

// Import các hàm lưu/xoá/đọc ảnh từ storage cục bộ
import { savePhotos, loadPhotos, deletePhotoById } from '../storage';

// Import hàm gọi Gemini để tạo mô tả ảnh
import { generatePhotoDescription } from '../services/geminiService';

// Import thư viện tạo UUID (ID duy nhất)
import { v4 as uuidv4 } from 'uuid';


/**
 * HomeScreen - màn hình chính của app
 * Cho phép chụp ảnh, lưu và hiển thị danh sách ảnh đã lưu
 */
export default function HomeScreen({ navigation }) {

    // State để lưu danh sách ảnh
    const [photos, setPhotos] = useState([]);

    /**
     * useEffect chạy 1 lần khi load màn hình
     * -> Tải danh sách ảnh đã lưu từ local storage
     */
    useEffect(() => {
        (async () => {
            const data = await loadPhotos();
            setPhotos(data);
        })();
    }, []);

    /**
     * Hàm mở camera chụp ảnh
     */
    const takePhoto = async () => {
        // Xin quyền truy cập camera
        const permissionResult = await ImagePicker.requestCameraPermissionsAsync();
        if (!permissionResult.granted) {
            alert("Permission to access camera is required!");
            return;
        }

        // Mở camera và chụp
        const result = await ImagePicker.launchCameraAsync({ quality: 0.5 });
        if (result.canceled) return;

        // Lấy vị trí GPS hiện tại
        const location = await Location.getCurrentPositionAsync({});

        // Tạo object ảnh mới
        const newPhoto = {
            id: uuidv4(),                         // Tạo ID duy nhất
            uri: result.assets[0].uri,            // Đường dẫn ảnh trong máy
            latitude: location.coords.latitude,   // Toạ độ vĩ độ
            longitude: location.coords.longitude, // Toạ độ kinh độ
            description: '',                      // Mô tả AI (chưa có)
        };

        // Gọi Gemini để tạo mô tả cho ảnh
        newPhoto.description = await generatePhotoDescription(newPhoto.uri);

        // Thêm ảnh mới vào đầu danh sách
        const newList = [newPhoto, ...photos];
        setPhotos(newList);

        // Lưu danh sách ảnh mới vào local storage
        await savePhotos(newList);
    };

    /**
     * Hiện hộp thoại xác nhận xoá ảnh
     */
    const confirmDelete = (id) => {
        Alert.alert('Delete', 'Delete this photo?', [
            { text: 'Cancel' },
            { text: 'Delete', onPress: () => handleDelete(id) },
        ]);
    };

    /**
     * Xoá ảnh theo ID
     */
    const handleDelete = async (id) => {
        // Xoá trong storage
        const updated = await deletePhotoById(id);

        // Cập nhật state
        setPhotos(updated);
    };

    /**
     * Hàm render từng item trong FlatList
     */
    const renderItem = ({ item }) => (
        <TouchableOpacity
            onPress={() => navigation.navigate('PhotoDetail', { photo: item })}
        >
            <View style={styles.itemContainer}>
                <Image source={{ uri: item.uri }} style={styles.thumbnail} />
                <View style={{ flex: 1, marginLeft: 10 }}>
                    <Text numberOfLines={2}>
                        {item.description || 'No description'}
                    </Text>
                    <Button title="Delete" onPress={() => confirmDelete(item.id)} />
                </View>
            </View>
        </TouchableOpacity>
    );

    /**
     * Render màn hình chính
     */
    return (
        <View style={styles.container}>
            <Button title="Take Photo" onPress={takePhoto} />

            <FlatList
                data={photos}                    // Dữ liệu ảnh
                keyExtractor={(item) => item.id} // Khoá duy nhất
                renderItem={renderItem}          // Hàm vẽ từng item
            />
        </View>
    );
}

/**
 * StyleSheet cho giao diện
 */
const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 10
    },
    itemContainer: {
        flexDirection: 'row',
        padding: 10,
        alignItems: 'center'
    },
    thumbnail: {
        width: 80,
        height: 80,
        borderRadius: 8
    },
});
