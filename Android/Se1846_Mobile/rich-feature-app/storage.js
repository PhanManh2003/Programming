/*
Vai trò: 
- Lưu danh sách ảnh vào AsyncStorage (bộ nhớ thiết bị).

- Tải danh sách ảnh từ AsyncStorage khi mở lại app.

- Xoá 1 ảnh khỏi danh sách.

✅ Đây là data layer.
→ Giúp app "nhớ" dữ liệu sau khi đóng/mở lại.
*/
// storage.js
import AsyncStorage from '@react-native-async-storage/async-storage';

const STORAGE_KEY = 'PHOTO_DATA';

// Lưu mảng ảnh
export const savePhotos = async (photos) => {
  await AsyncStorage.setItem(STORAGE_KEY, JSON.stringify(photos));
};

// Tải mảng ảnh
export const loadPhotos = async () => {
  const data = await AsyncStorage.getItem(STORAGE_KEY);
  return data ? JSON.parse(data) : [];
};

// Xoá ảnh theo ID
export const deletePhotoById = async (id) => {
  const photos = await loadPhotos();
  const newPhotos = photos.filter(p => p.id !== id);
  await savePhotos(newPhotos);
  return newPhotos;
};
