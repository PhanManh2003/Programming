/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Byte_Stream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class R_ByteStream {

    /* FileInputStream và FileOutputStream là hai lớp thuộc loại 
byte stream được sử dụng để đọc và ghi dữ liệu dưới dạng byte từ và đến tệp tin.
    
Dữ liệu được đọc và ghi dưới dạng byte, nên chúng thích hợp cho việc đọc và 
ghi dữ liệu nhị phân, chẳng hạn hình ảnh, âm thanh, v.v. */
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("D:\\newfile.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                // Xử lý dữ liệu byte, ví dụ: in ra màn hình
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
