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
public class DeepEquals {
//    Phương thức deeprequals() được sử dụng để so sánh hai mảng hai chiều có bằng nhau 

    public static void main(String args[]) {
        String[][] s1 = {{"java", "swings", "j2ee"}, {"struts", "jsp", "hibernate"}};
        String[][] s2 = {{"java", "swings", "j2ee"}, {"struts", "jsp", "hibernate"}};

        System.out.println(Arrays.equals(s1, s2)); // Output : false
        System.out.println(Arrays.deepEquals(s1, s2)); // Output : true
    }

}
