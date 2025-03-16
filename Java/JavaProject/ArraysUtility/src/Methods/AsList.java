 
package Methods;

import java.util.Arrays;
import java.util.List;

 
public class AsList {
//     nó được sử dụng để chuyển đổi một mảng thành một đối tượng List

    public static void main(String args[]) {
        // Chuyển đổi mảng thành List
        String[] array = {"apple", "banana", "orange"};
        List<String> list = Arrays.asList(array);

        // In ra các phần tử trong List
        System.out.println(list);
    }
}
