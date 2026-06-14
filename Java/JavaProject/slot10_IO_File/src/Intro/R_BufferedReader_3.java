package Intro;

import java.io.BufferedReader;
import java.io.FileReader;

public class R_BufferedReader_3 {

    public static void main(String args[]) throws Exception {
        // không cần khai báo null vì ko có try-catch
        FileReader fr = new FileReader("D:\\newfile.txt");
        BufferedReader br = new BufferedReader(fr);

        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
        fr.close();
    }
}
