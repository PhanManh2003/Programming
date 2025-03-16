 

/*
- Iterable is an interface that defines a collection that can be iterated over.

- The Iterator interface is used to iterate over the elements in a collection
one at a time.

- Iterable interface defines a method: Iterator<T> iterator(); which 
returns an object that implements the Iterator<T> interface.
( T: String, int, Student, ...)

- Iterable có những phương thức sau:
    1. Iterator<T> iterator()
    2. default void forEach(Consumer<? super T> action) (forEach này từ Java 8 mới có )
        cú pháp: 
            collection.forEach(element -> {
                   // Xử lý element
                });

    3. default Spliterator<T> spliterator()

- The Iterator ỉnterface có những phương thức trừu tượng sau:
1.  public boolean hasNext()	Nó trả về true nếu iterator còn phần tử kế tiếp phần tử đang duyệt.
2.  public object next()	Nó trả về phần tử hiện tại và di chuyển con trỏ trỏ tới phần tử tiếp theo.
3.  public void remove()	Nó loại bỏ phần tử cuối được trả về bởi Iterator. Nó hiếm khi được sử dụng.

- Các collection mà implement List thì có thể sử dụng iterator bằng cách
gọi listIterator(), sẽ có nhiều phương thức để làm việc hơn ngoài 3 phương thức
kể trên

CHÚ Ý: Iterable và Map trong Java không làm việc với kiểu nguyên thủy mà chỉ làm việc với kiểu
tham chiếu ( object) vì Generics in Java only support reference types.
Nếu đưa giá trị primitive thì giá trị sẽ dc auto boxing ( cơ chế chuyển đổi dữ liệu từ 
kiểu tham trị sang tham chiếu )

*/
public class Iterable_Iterator {
    
}
