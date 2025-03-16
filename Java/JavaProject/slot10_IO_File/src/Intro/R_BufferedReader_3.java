/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Intro;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author manhpthe172481
 */
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
