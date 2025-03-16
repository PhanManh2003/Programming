package Map;

import java.util.HashMap;
import java.util.Map.Entry;

/*
-  HashMap and LinkedHashMap allow null keys and values, but TreeMap doesn't
allow any null key. A HashMap can allow only 1 null key  and multiple null
values.

- Hashmap is not synchronized.

- Index = hashcode(Key) & (n-1)  Index = 2657860 & (16-1) = 4 
(Where n is the size of the array).

- hashCode() là một phương thức có ở tất cả các đối tượng trong Java.
 */
public class HashMap_ {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating
// HashMap
        map.put(1, "Mango"); // Put elements in Map
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(1, "Grapes"); // trying duplicate key => replace
        System.out.println("Iterating Hashmap...");
        for (Entry<Integer, String> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        System.out.println(map);

    }
}
