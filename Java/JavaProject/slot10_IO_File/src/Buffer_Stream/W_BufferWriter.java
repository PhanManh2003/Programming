package Buffer_Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
