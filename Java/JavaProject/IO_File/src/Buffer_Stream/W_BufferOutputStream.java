/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buffer_Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class W_BufferOutputStream {

    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\newfile.txt"))) {
            String data = "Hello, Buffered Byte Stream!";
            byte[] byteArray = data.getBytes(); // Chuyển đổi chuỗi thành mảng byte
            bos.write(byteArray); // Ghi mảng byte vào tệp tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
