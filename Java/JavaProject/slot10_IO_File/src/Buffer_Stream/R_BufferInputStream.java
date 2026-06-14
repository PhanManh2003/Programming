package Buffer_Stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class R_BufferInputStream {

    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\newfile.txt"))) {
            int data;
            while ((data = bis.read()) != -1) {
                // Xử lý dữ liệu byte, ví dụ: in ra màn hình
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
