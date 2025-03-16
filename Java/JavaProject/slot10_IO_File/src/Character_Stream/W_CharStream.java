/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character_Stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class W_CharStream {

    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("D:\\newfile.txt")) {
            String data = "Ronaldo Delima";
            fw.write(data); // Ghi chuỗi vào tệp tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
