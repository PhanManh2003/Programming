/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buffer_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class R_BufferReader {

    // FileReader để mở luồng đọc từ tệp tin
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\newfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Xử lý dữ liệu dòng, ví dụ: in ra màn hình
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
