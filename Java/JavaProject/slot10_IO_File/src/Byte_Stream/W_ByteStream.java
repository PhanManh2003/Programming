package Byte_Stream;

import java.io.FileOutputStream;
import java.io.IOException;

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
