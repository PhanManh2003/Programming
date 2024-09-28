/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compare_2_Objects;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    /* toán tử == trong Java là toán tử so sánh địa chỉ nơi đối tượng được cấp phát
        chứ toán tử này không hề so sánh tới các thuộc tính của đối tượng.*/
    public static void main(String[] args) {
        Student s1 = new Student(1000, "Viet", "Bac Ninh");
        Student s2 = new Student(1000, "Viet", "Bac Ninh");
        System.out.println(s1.equals(s2));
    }
}
