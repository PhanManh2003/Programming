package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
- Java TreeMap class is a red-black tree based implementation

-  It implements the NavigableMap interface and
extends AbstractMap class.

- TreeMap cannot have a null key but can have multiple null values.

- non-synchronized

- Java TreeMap cannot have a null key but can have multiple null values

 */
public class TreeMap_ {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Insert key-value pairs
        treeMap.put(10, "Ten");
        treeMap.put(20, "Twenty");
        treeMap.put(30, "Thirty");
        treeMap.put(40, "Forty");
        treeMap.put(50, "Fifty");

        System.out.println("Original TreeMap: " + treeMap); // {10=Ten, 20=Twenty, 30=Thirty, 40=Forty, 50=Fifty}

        // ceilingEntry(K key) and ceilingKey(K key)
        System.out.println("ceilingEntry(25): " + treeMap.ceilingEntry(25)); // 30=Thirty
        System.out.println("ceilingKey(25): " + treeMap.ceilingKey(25)); // 30

        // floorEntry(K key) and floorKey(K key)
        System.out.println("floorEntry(25): " + treeMap.floorEntry(25)); // 20=Twenty

        // higherEntry(K key) and higherKey(K key)
        System.out.println("higherEntry(20): " + treeMap.higherEntry(20)); // 30=Thirty
        System.out.println("higherKey(20): " + treeMap.higherKey(20)); // 30

        // lowerEntry(K key) and lowerKey(K key)
        System.out.println("lowerEntry(30): " + treeMap.lowerEntry(30)); // 20=Twenty
        System.out.println("lowerKey(30): " + treeMap.lowerKey(30)); // 20

        // keySet()
        System.out.println("keySet(): " + treeMap.keySet()); // [10, 20, 30, 40, 50]

        // firstEntry() lastEntry()  
        System.out.println("firstEntry(): " + treeMap.firstEntry()); // 10=Ten
        System.out.println("lastEntry(): " + treeMap.lastEntry()); // 50=Fifty
        
        // firstKey() and lastKey()
        System.out.println("firstKey(): " + treeMap.firstKey()); // 5
        System.out.println("lastKey(): " + treeMap.lastKey()); // 40


        // pollFirstEntry() and pollLastEntry(): remove and return Map.Entry<K,V>
        System.out.println("pollFirstEntry(): " + treeMap.pollFirstEntry()); // 10=Ten
        System.out.println("pollLastEntry(): " + treeMap.pollLastEntry()); // 50=Fifty
        System.out.println("After polling: " + treeMap); // {20=Twenty, 30=Thirty, 40=Forty}

        // void putAll(Map<? extends K,? extends V> map)
        Map<Integer, String> anotherMap = new HashMap<>();
        anotherMap.put(5, "Five");
        anotherMap.put(25, "Twenty-Five");
        treeMap.putAll(anotherMap);
        System.out.println("After putAll(): " + treeMap); // {5=Five, 20=Twenty, 25=Twenty-Five, 30=Thirty, 40=Forty}

        // V get(Object key)
        treeMap.replace(25, "Updated Twenty-Five");
        System.out.println("After replace(): " + treeMap); // {5=Five, 20=Twenty, 25=Updated Twenty-Five, 30=Thirty, 40=Forty}

        
        // V get(Object key)
        System.out.println("get(25): " + treeMap.get(25)); // Updated Twenty-Five

        // V remove(Object key)
        treeMap.remove(25);
        System.out.println("After remove(25): " + treeMap); // {5=Five, 20=Twenty, 30=Thirty, 40=Forty}

        //  Set<Map.Entry<K,V>> entrySet()
        System.out.println("entrySet(): " + treeMap.entrySet()); // [5=Five, 20=Twenty, 30=Thirty, 40=Forty]

        // size()
        System.out.println("size(): " + treeMap.size()); // 4

        // values()
        System.out.println("values(): " + treeMap.values()); // [Five, Twenty, Thirty, Forty]
    }
}
