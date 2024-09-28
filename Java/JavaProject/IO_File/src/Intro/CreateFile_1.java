/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Intro;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class CreateFile_1 {

    public static void main(String[] args) {
        try {

            File file = new File("D:\\newfile.txt");
            
            if (file.createNewFile()) {
        /* Khi được gọi, phương thức createNewFile() sẽ kiểm tra xem tệp có tồn tại hay không. 
       Nếu tệp chưa tồn tại, nó sẽ tạo một tệp mới và trả về true. Nếu tệp đã tồn tại, nó sẽ trả về false. */
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
