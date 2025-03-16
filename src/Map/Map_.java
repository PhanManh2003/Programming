package Map;


/*CÁC PHƯƠNG THỨC PHỔ BIẾN TRONG MAP INTERFACE:
1. V put(K key, V value):
    - Trả về giá trị cũ được ánh xạ với key,
    - hoặc null nếu không có giá trị cũ.
2. void putAll(Map<? extends K, ? extends V> m)

3. V putIfAbsent(K key, V value): 
    - Chỉ thêm cặp key-value nếu key chưa tồn tại trong map.
    - Trả về giá trị cũ nếu khóa đã tồn tại, hoặc null nếu thêm thành công.

4. V get(Object key)
5. V getOrDefault(Object key, V defaultValue): ko tồn tại thì trả về defaultValue
6. V remove(Object key)
7. boolean remove(Object key, Object value)
8. boolean containsKey(Object key)
9. boolean containsValue(Object value)
10. boolean isEmpty()
11. int size()
12. void clear()
13. Set<K> keySet()
14. Collection<V> values()
15. Set<Map.Entry<K, V>> entrySet()

--- phương thức liên quan đến đồng bộ
16. void forEach(BiConsumer<? super K, ? super V> action):
Thực thi một hành động cho mỗi cặp key-value

VD: map.forEach((key, value) -> System.out.println(key + ": " + value));

17. V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
Cập nhật giá trị cho key dựa trên một hàm ánh xạ.

VD: map.compute(1, (key, value) -> value + " Updated");

18. V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
19. V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
20. V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)

VD: map.merge(1, "Merged", (oldValue, newValue) -> oldValue + " & " + newValue);


21. void replaceAll(BiFunction<? super K,? super V,? extends V> function)
22. boolean replace(K key,  V oldValue,  V newValue)
23. 
*/

/*
Map có interface con Entry khai báo bên trong như sau:

public interface Map<K, V> {
    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }
}

Map.Entry đc triển khai trong lớp HashMap dưới dạng HashMap.Entry:

public class HashMap<K, V> implements Map<K, V> {
    // Các trường và phương thức của HashMap

    static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}

do cơ chế upcasting mà biến Map.Entry gọi dc getKey(), getValue() trên các phần tử
của HashMap,  TreeMap,...

*/
public class Map_ {
    
}
