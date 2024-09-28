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
public class DeepToString {
// Phương thức Arrays.deepToString() được sử dụng để nhận được biểu diễn chuỗi của các mảng đa chiều.

    public static void main(String args[]) {
        // 1-Dimensional Array
        String[] oneDArray = new String[]{
            "ONE", "TWO", "THREE", "FOUR", "FIVE"
        };
        System.out.println("One Dimensional Array : ");
        // Printing one dimensional array contents using deepToString() method
        System.out.println(Arrays.deepToString(oneDArray));

        // 2-Dimensional Array
        String[][] twoDArray = new String[][]{
            {"ONE", "TWO", "THREE", "FOUR"},
            {"FIVE", "SIX", "SEVEN"},
            {"EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"}
        };
        System.out.println("Two Dimensional Array : ");
        // Printing two dimensional array contents using deepToString() method
        System.out.println(Arrays.deepToString(twoDArray));

        // 3-Dimensional Array
        String[][][] threeDArray = new String[][][]{
            {
                {"ONE", "TWO", "THREE"},
                {"FOUR", "FIVE", "SIX", "SEVEN"}
            }, {
                {"EIGHT", "NINE", "TEN", "ELEVEN"},
                {"TWELVE", "THIRTEEN", "FOURTEEN"}
            }, {
                {"FIFTEEN", "SIXTEEN"},
                {"SEVENTEEN", "EIGHTEEN", "NINETEEN"},
                {"TWENTY", "TWENTY ONE"}
            }
        };
        System.out.println("Three Dimensional Array : ");
        // Printing three dimensional array contents using deepToString() method
        System.out.println(Arrays.deepToString(threeDArray));
    }
}
