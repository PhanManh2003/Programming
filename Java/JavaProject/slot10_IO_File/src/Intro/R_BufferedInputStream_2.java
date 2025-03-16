 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Intro;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author manhpthe172481
 */
public class R_BufferedInputStream_2 {
     public static void main(String[] args) throws IOException {
        File file = new File("D:\\newfile.txt");
         // khai báo để đảm bảo các luồng được đóng đúng cách ngay cả khi có lỗi
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
       
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
       /*  Mở một loạt luồng để đọc dữ liệu từ tệp tin: 
           FileInputStream để mở luồng đọc từ tệp tin,
           BufferedInputStream để tạo một bộ đệm cho việc đọc dữ liệu hiệu quả, 
           và DataInputStream để cung cấp các phương thức thuận tiện
           để đọc dữ liệu theo các kiểu dữ liệu cụ thể. */
            while (dis.available() != 0) {
            /*   Sử dụng vòng lặp để đọc từng dòng từ tệp tin sử dụng
              phương thức readLine() của DataInputStream và in ra màn hình. */
               System.out.println(dis.readLine());
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            bis.close();
            dis.close();
        }
    }
}
