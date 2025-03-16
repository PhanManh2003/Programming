package Map;

import java.util.Hashtable;
import java.util.Set;

/*
- 1 Hash Table gồm 2 thành phần chính : index và bucket. Bucket chứa các cặp 
(key-value) với key và value khác null; key là duy nhất

- Hash Table được đồng bộ

Cơ chế hoạt động:
1. key được đưa vào hash function để trả về 1 hash code
2. Từ hash code ta tính dc index của table
3. Bucket tại index này sẽ lưu trữ (key-value) với key ở trên

Xử lí xung đột(Collision): Nếu 2 key có cùng hash code, sẽ có 1 trong 3 cách:
    1. Chaining: Các phần tử sẽ được lưu trữ trong một linked list trong 1 bucket
    2. Open Addressing: Tìm kiếm vị trí trống khác trong bảng với các phương pháp 
        Linear Probing, Quadratic Probing, Double Hashing
    3. Rehashing: tăng kích thước bảng hash và rehash các phần tử vào bảng mới
 */
public class HashTable_ {

    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

        // add elements
        hashtable.put(3, "C++");
        hashtable.put(1, "Java");
        hashtable.put(2, "PHP");
        hashtable.put(4, "Python");
        String x = hashtable.put(4, "Python");
        System.out.println(x); // Python
        // remove element
        hashtable.remove(2);
        // show hashtable
        Set<Integer> keySet = hashtable.keySet();
        for (Integer key : keySet) {
            System.out.println(key + "-" + hashtable.get(key));
        }
        hashtable.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}


