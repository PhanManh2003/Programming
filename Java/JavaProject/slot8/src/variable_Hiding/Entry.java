/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variable_Hiding;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    public static void main(String[] args) {
/* Variable Hiding xảy ra khi lớp con khai báo thuộc tính có tên giống tên thuộc tính ở lớp cha,
lúc này thuộc tính của lớp cha sẽ không bị lớp con ghi đè mà bị lớp con ẩn đi */
        SuperClass a = new SubClass();
        System.out.println(a.x);
        System.out.println(((SubClass) a).x); // down-casting
    }
}
