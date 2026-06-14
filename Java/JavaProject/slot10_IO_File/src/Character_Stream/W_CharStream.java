package Character_Stream;

import java.io.FileWriter;
import java.io.IOException;

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
