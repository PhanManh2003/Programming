package Inheritance;

public class Entry {

    /* constructor của lớp con luôn gọi tới constructor của lớp cha 
(nếu không chỉ rõ thì lớp con sẽ luôn gọi đến constructor mặc định của lớp cha */
 /* Tóm lại: constructor mặc định của con thì gọi mặc định của cha, constructor tham số của con thì gọi 
constructor có tham số của cha    */
    public static void main(String[] args) {
        Student s = new Student();
    }
}
