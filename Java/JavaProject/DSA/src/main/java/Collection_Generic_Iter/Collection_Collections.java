
import java.util.Collections;



/*
    Dưới đây là một số phương thức static quan trọng của lớp Collections trong Java:

sort(List<T> list): Sắp xếp các phần tử trong danh sách theo thứ tự 
    tăng dần dựa trên thứ tự tự nhiên của các phần tử hoặc sử dụng Comparable interface nếu phần tử đó implement.

reverse(List<?> list): Đảo ngược thứ tự của các phần tử trong danh sách.

binarySearch(List<? extends Comparable<? super T>> list, T key): Tìm kiếm nhị 
    phân một phần tử cụ thể trong danh sách đã sắp xếp. Danh sách phải được sắp xếp
    theo thứ tự tăng dần trước khi gọi hàm này.

shuffle(List<?> list): Trộn ngẫu nhiên các phần tử trong danh sách.

replaceAll(List<T> list, T oldValue, T newValue): Thay thế tất cả các trường hợp của giá trị oldValue trong danh sách bằng newValue.

swap(List<?> list, int i, int j): Hoán đổi vị trí của hai phần tử trong danh sách tại các chỉ số i và j.

copy(List<? super T> dest, List<? extends T> src): Sao chép toàn bộ nội dung của danh sách nguồn src vào danh sách đích dest.

fill(List<? super T> list, T obj): Điền tất cả các phần tử của danh sách với giá trị chỉ định obj.

min() , max(), rotate(), addAll()
*/


/*
CÁC PHƯƠNG THỨC PHỔ BIẾN TRONG INTERFACE COLLECTION (cả abstract lẫn default):


1.public boolean add(Object element)              Được sử dụng để chèn một phần tử vào collection.
2.public boolean addAll(Collection c)             Được sử dụng để chèn các phần tử collection được chỉ định vào collection gọi phương thức này.
3.public boolean remove(Object element)           Được sử dụng để xóa phần tử từ collection.
4.public boolean removeAll(Collection c)          Được sử dụng để xóa tất cả các phần tử của collection được chỉ định từ collection gọi phương thức này.
5.public boolean retainAll(Collection c)          Được sử dụng để xóa tất cả các thành phần từ collection gọi phương thức này ngoại trừ collection được chỉ định.
6.public int size()                               Trả lại tổng số các phần tử trong collection.
7.public void clear()                             Loại bỏ tổng số của phần tử khỏi collection.
8.public boolean contains(Object element) 	  Được sử dụng để tìm kiếm phần tử.
9.public boolean containsAll(Collection c)	  Được sử dụng để tìm kiếm collection được chỉ định trong collection.
10.public Iterator iterator()                     Trả về một iterator.
11.public Object[] toArray()                      Chuyển đổi collection thành mảng (array).
12.public boolean isEmpty()                       Kiểm tra nếu collection trống.
13.public boolean equals(Object element)          So sánh 2 collection.
14.public int hashCode()                          Trả về số hashcode của collection.
...
*/
public class Collection_Collections {
    public static void main(String[] args) {
        
    }
}
