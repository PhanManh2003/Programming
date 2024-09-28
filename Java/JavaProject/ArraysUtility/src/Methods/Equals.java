/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import java.util.Arrays;

/**
 *
 * @author manhpthe172481
 */
public class Equals {
//    equals() được sử dụng để so sánh hai mảng có bằng nhau hay không.

    public static void main(String args[]) {
        String[] s1 = {"java", "j2ee", "struts", "hibernate"};
        String[] s2 = {"jsp", "spring", "jdbc", "hibernate"};
        String[] s3 = {"java", "j2ee", "struts", "hibernate"};
        String[] s4 = {"java", "struts", "j2ee", "hibernate"};

        System.out.println(Arrays.equals(s1, s2)); // Output : false
        System.out.println(Arrays.equals(s1, s3)); // Output : true
        System.out.println(Arrays.equals(s1, s4)); // Output : false
        
    }
}
