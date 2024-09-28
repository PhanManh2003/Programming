/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buffer_Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class W_BufferWriter {
    public static void main(String[] args) {
        // FileWriter để mở luồng ghi vào tệp tin
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\newfile.txt"))) {
            String data = "Hello, Buffered Char Stream!";
            bw.write(data); // Ghi chuỗi vào tệp tin
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
