package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
- Java ArrayList class can contain duplicate elements.
- Java ArrayList class maintains insertion order.
- Java ArrayList class is non synchronized.
- Java ArrayList allows random access because array works at the index basis. 
The elements in an ArrayList can be accessed directly and efficiently by using
the get() and set() methods.

- In ArrayList, manipulation ( insert/delete) is little bit slower than the LinkedList
in Java because a lot of shifting needs to occur if any element is removed 
from the array list.
*/


public class ArrayList_ {

    public static void main(String[] args) {
        // Constructor 1: ArrayList()
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("List 1 is empty: " + list1.isEmpty());  // true

        // Constructor 2: ArrayList(Collection<? extends E> c) ) E là reference data type
        Collection<String> collection = Arrays.asList("Apple", "Banana", "Cherry");
        ArrayList<String> list2 = new ArrayList<>(collection);
        System.out.println("List 2: " + list2);  // [Apple, Banana, Cherry]

        // Constructor 3: ArrayList(int capacity) 
        /*
        Việc chỉ định capacity giúp tối ưu hóa hiệu suất và tiết kiệm bộ nhớ 
        trong các tình huống khi bạn biết trước số lượng phần tử mà ArrayList sẽ chứa.
        
        Bởi vì:
        ArrayList tự động mở rộng dung lượng mỗi khi số lượng phần tử vượt quá 
        dung lượng hiện tại (thường là gấp đôi dung lượng cũ). Tuy nhiên, 
        việc mở rộng này yêu cầu tái cấp phát bộ nhớ và sao chép các phần tử 
        vào một mảng mới, điều này có thể gây tốn kém về hiệu suất, đặc biệt là
        khi có quá nhiều phần tử được thêm vào.
        */
        ArrayList<String> list3 = new ArrayList<>(10);
        System.out.println("List 3 initial capacity: " + list3.size());  // 0

        // Method 1: add(int index, E element) E là reference data type -> void
        list2.add(1, "Orange");  // Insert at index 1
        System.out.println("List 2 after add(index, element): " + list2);  // [Apple, Orange, Banana, Cherry]

        // Method 2: add(E e) E là reference data type -> boolean
        list1.add("Grapes");
        list1.add("Mango");
        System.out.println("List 1 after add(e): " + list1);  // [Grapes, Mango]

        // Method 3: addAll(Collection<? extends E> c) -> boolean
        list1.addAll(collection);
        System.out.println("List 1 after addAll(collection): " + list1);  // [Grapes, Mango, Apple, Banana, Cherry]

        // Method 4: E get(int index)
        System.out.println("Element at index 2 in List 2: " + list2.get(2));  // Banana

        // Method 5: boolean isEmpty()
        System.out.println("List 3 is empty: " + list3.isEmpty());  // true

        // Method 6: contains(Object o) -> boolean
        System.out.println("List 1 contains 'Mango': " + list1.contains("Mango"));  // true

        // Method 7: indexOf(Object o) -> int
        System.out.println("Index of 'Banana' in List 2: " + list2.indexOf("Banana"));  // 2

        // Method 8: E remove(int index) 
        list2.remove(2);  // Remove the element at index 2
        System.out.println("List 2 after remove(index): " + list2);  // [Apple, Orange, Cherry]

        // Method 9: remove(Object o) -> boolean
        list2.remove("Cherry");
        System.out.println("List 2 after remove(object): " + list2);  // [Apple, Orange]

        // Method 10: removeAll(Collection<?> c) -> boolean
        list2.removeAll(collection);
        System.out.println("List 2 after removeAll(collection): " + list2);  // []

        // Method 11: removeIf(Predicate<? super E> filter) -> boolean
            // Predicate là 1 functional interface có duy nhất 1 phương thức: boolean test(T t)
            // ? super E là bất kì kiểu superclass của E , bao gồm chính nó
            // filter phải trả về giá trị kiểu boolean
        list1.removeIf(s -> s.startsWith("B"));
        System.out.println("List 1 after removeIf: " + list1);  // [Grapes, Mango, Apple, Cherry]

        // Method 12: protected void removeRange(int fromIndex, int toIndex)
        // This is protected, so we can't use it directly. Let's skip this.
        // Method 13: retainAll(Collection<?> c)
        list1.retainAll(Arrays.asList("Grapes", "Apple"));
        System.out.println("List 1 after retainAll: " + list1);  // [Grapes, Apple]

        // Method 14: subList(int fromIndex, int toIndex) -> List<E>
        List<String> subList = list1.subList(0, 2);
        System.out.println("Sublist of List 1: " + subList);  // [Grapes, Apple]

        // Method 15: size()
        System.out.println("Size of List 1: " + list1.size());  // 2
    }
}
