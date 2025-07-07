// services/geminiService.js

// Import thư viện Google Generative AI (Gemini SDK)
import { GoogleGenerativeAI } from '@google/generative-ai';

// Import biến môi trường chứa API KEY từ file .env
import { GEMINI_API_KEY } from '@env';

// Import thư viện hệ thống file của Expo (dùng để đọc file thành base64)
import * as FileSystem from 'expo-file-system';


/**
 * Khởi tạo client Gemini với API Key
 * Đây là đối tượng sẽ được dùng để gọi các model AI
 */
const genAI = new GoogleGenerativeAI(GEMINI_API_KEY);


/**
 * Hàm convert ảnh từ đường dẫn (uri) sang chuỗi base64
 * 
 * @param {string} uri - Đường dẫn file ảnh trong máy
 * @returns {Promise<string>} - Chuỗi base64 đại diện cho ảnh
 */
export async function imageToBase64(uri) {
  // Đọc file ảnh và trả về chuỗi base64
  return await FileSystem.readAsStringAsync(uri, {
    encoding: FileSystem.EncodingType.Base64,
  });
}


/**
 * Hàm gọi Gemini để mô tả nội dung của ảnh
 * 
 * @param {string} imageUri - Đường dẫn ảnh
 * @returns {Promise<string>} - Kết quả mô tả bằng tiếng Anh
 */
export async function generatePhotoDescription(imageUri) {
  try {
    // Tạo model Gemini, chọn model hỗ trợ xử lý ảnh
    const model = genAI.getGenerativeModel({ model: 'gemini-pro-vision' });

    // Chuyển ảnh sang base64 để gửi lên server AI
    const imageBase64 = await imageToBase64(imageUri);

    // Gửi yêu cầu mô tả với prompt + dữ liệu ảnh
    const result = await model.generateContent([
      { text: "Please describe this photo." }, // prompt yêu cầu mô tả
      {
        inlineData: {
          mimeType: "image/jpeg", // loại ảnh
          data: imageBase64,      // dữ liệu base64
        },
      },
    ]);

    // Trích kết quả mô tả text từ phản hồi
    return result.response.text();

  } catch (error) {
    // Xử lý lỗi (in ra console và trả về chuỗi fallback)
    console.error('Gemini error:', error);
    return "AI description unavailable.";
  }
}
