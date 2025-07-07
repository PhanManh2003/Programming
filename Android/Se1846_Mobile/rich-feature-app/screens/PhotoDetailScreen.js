// screens/PhotoDetailScreen.js

// Import React và các thành phần giao diện
import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';

// Import MapView và Marker để hiển thị bản đồ
import MapView, { Marker } from 'react-native-maps';


/**
 * PhotoDetailScreen
 * 
 * Màn hình hiển thị chi tiết 1 tấm ảnh
 * - Xem ảnh lớn
 * - Xem mô tả
 * - Hiển thị vị trí trên bản đồ
 */
export default function PhotoDetailScreen({ route }) {

    // Lấy object 'photo' từ tham số truyền qua navigation
    const { photo } = route.params;

    return (
        <View style={styles.container}>

            {/* Ảnh lớn */}
            <Image
                source={{ uri: photo.uri }}
                style={styles.image}
            />

            {/* Mô tả ảnh (text AI sinh ra) */}
            <Text style={styles.description}>
                {photo.description}
            </Text>

            {/* Bản đồ hiển thị vị trí chụp ảnh */}
            <MapView
                style={styles.map}
                initialRegion={{
                    latitude: photo.latitude,         // Toạ độ vĩ độ
                    longitude: photo.longitude,       // Toạ độ kinh độ
                    latitudeDelta: 0.01,              // Zoom bản đồ theo chiều vĩ độ
                    longitudeDelta: 0.01,             // Zoom bản đồ theo chiều kinh độ
                }}
            >
                {/* Marker (chấm trên bản đồ) */}
                <Marker
                    coordinate={{
                        latitude: photo.latitude,
                        longitude: photo.longitude
                    }}
                    title="Photo Location"            // Tiêu đề marker
                    description={photo.description}   // Nội dung marker
                />
            </MapView>

        </View>
    );
}


/**
 * StyleSheet
 * Định nghĩa style cho các thành phần
 */
const styles = StyleSheet.create({
    container: {
        flex: 1
    },
    image: {
        width: '100%',
        height: 300
    },
    description: {
        padding: 10,
        fontSize: 16
    },
    map: {
        flex: 1
    },
});
