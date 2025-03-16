/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character_Stream;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class R_CharStream {

    /* FileReader và FileWriter là hai lớp thuộc loại character stream được 
    sử dụng để đọc và ghi dữ liệu dưới dạng ký tự từ và đến tệp tin. Dữ liệu
    được đọc và ghi dưới dạng ký tự, nên chúng thích hợp cho việc đọc và ghi văn bản. */
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("D:\\newfile.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                // Xử lý dữ liệu ký tự, ví dụ: in ra màn hình
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
