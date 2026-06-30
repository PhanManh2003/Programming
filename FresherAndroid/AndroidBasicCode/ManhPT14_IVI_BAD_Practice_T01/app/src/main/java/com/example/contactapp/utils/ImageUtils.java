package com.example.contactapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {

    /**
     * Chuyển Bitmap → Base64 string để lưu vào Room.
     */
    public static String bitmapToBase64(Bitmap bitmap) {
        if (bitmap == null) return null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Nén ảnh xuống quality 70 để tiết kiệm dung lượng DB
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] bytes = baos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    /**
     * Chuyển Base64 string → Bitmap để hiển thị lên ImageView.
     */
    public static Bitmap base64ToBitmap(String base64) {
        if (base64 == null || base64.isEmpty()) return null;
        try {
            byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Chuyển Uri (ảnh chọn từ gallery) → Base64 string.
     */
    public static String uriToBase64(Context context, Uri uri) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) return null;

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();

            // Scale down nếu ảnh quá lớn (tránh OOM)
            bitmap = scaleBitmap(bitmap, 400, 400);
            return bitmapToBase64(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Scale bitmap về kích thước tối đa maxW x maxH, giữ tỉ lệ.
     */
    public static Bitmap scaleBitmap(Bitmap src, int maxW, int maxH) {
        if (src == null) return null;
        int w = src.getWidth();
        int h = src.getHeight();
        if (w <= maxW && h <= maxH) return src;

        float ratio = Math.min((float) maxW / w, (float) maxH / h);
        int newW = Math.round(w * ratio);
        int newH = Math.round(h * ratio);
        return Bitmap.createScaledBitmap(src, newW, newH, true);
    }

    /**
     * Trả về chữ cái đầu của tên để hiển thị avatar mặc định.
     * "Nguyen Van A" → "N"
     */
    public static String getAvatarLetter(String name) {
        if (name == null || name.trim().isEmpty()) return "?";
        return String.valueOf(name.trim().charAt(0)).toUpperCase();
    }

    /**
     * Chọn màu avatar dựa trên chữ cái đầu (xoay vòng 5 màu).
     */
    public static int getAvatarColor(String name) {
        int[] colors = {
                0xFFE91E63, // pink
                0xFF9C27B0, // purple
                0xFF3F51B5, // indigo
                0xFF009688, // teal
                0xFFFF5722  // deep orange
        };
        if (name == null || name.isEmpty()) return colors[0];
        int index = Math.abs(name.charAt(0)) % colors.length;
        return colors[index];
    }
}
