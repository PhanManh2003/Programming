package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Serialization đơn giản chỉ là chuyển từ một object tồn tại thành một mảng byte
hay còn gọi là byte stream.
( chỉ lưu thuộc tính của đối tượng và metadata của class. Ko lưu phương thức 
của đối tượng)

LƯU Ý:
- Các thuộc tính static hoặc đc đánh dấu transient sẽ ko serialize
- Nếu superclass là Serializable (implement Serializable) thì các lớp con
của nó sẽ tự động được Serializable.
- Khi bạn serialize bất kỳ object nào mà nó có chứa tham chiếu đến object khác
thì Java serialization sẽ serialize luôn cả object đó 
(nếu object được tham chiếu không implement  java.io.Serializable thì ngoại lệ
java.io.NotSerializableException sẽ xảy ra.



Tại sao phải serialize object:
1. để lưu đối tượng vào file
2. để truyền đối tượng qua mạng trong các ứng dụng client-server
3. lưu trữ trong database


How to:
- Để mà serialize một object, bạn cần phải đảm bảo rằng class của object đó
implements java.io.Serializable interface. Serializable interface chỉ là một
marker interface, bản thân nó chẳng định nghĩa 1 phương thức nào cả 😄, 
nó chỉ có nhiệm vụ chỉ ra đây là object có thể serialized được.

- Hai lớp ObjectInputStream và ObjectOutputStream chứa các phương thức dùng 
để serializing và deserializing một object.

- phương thức public final void writeObject(Object x) của ObjectOutputStream
để serializes một Object và gửi nó đến phương thức public final Object readObject() 
của ObjectInputStream để deserializes.

- cần phải có FileInputStream và FileOutputStream để mở file và cung cấp 1 kênh 
để ghi dữ liệu vào file. Còn ObjectOutputStream sẽ "đóng gói" đối tượng 
thành dữ liệu có thể lưu vào file.
 */
public class Entry {

    public static void main(String[] args) {

        // Serialize  
//        Employee e = new Employee();
//        e.name = "Phan Tien Manh";
//        e.address = "17 Me Tri Thuong - Nam Từ Liêm";
//        e.SSN = 11122333;
//        e.number = 101;
//
//        try {
//            FileOutputStream fileOut = new FileOutputStream(
//                    "D:\\Programming\\Java\\JavaProject\\slot11_Serialization\\serial.txt");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(e);
//            out.close();
//            fileOut.close();
//            System.out.printf("Serialized data is saved in "
//                    + "D:\\Programming\\Java\\JavaProject\\slot11_Serialization\\serial.txt");
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
        // Deserialize
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream(
                    "D:\\Programming\\Java\\JavaProject\\slot11_Serialization\\serial.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
