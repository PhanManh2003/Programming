/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Byte_Stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class W_ByteStream {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("D:\\newfile.txt")) {
            String data = "Lionel Messi";
            byte[] byteArray = data.getBytes(); // Chuyển đổi chuỗi thành mảng byte
            fos.write(byteArray); // Ghi mảng byte vào tệp tin
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
