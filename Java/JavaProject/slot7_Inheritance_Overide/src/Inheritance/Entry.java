package Inheritance;

public class Entry {

/* constructor của lớp con luôn gọi tới constructor của lớp cha 
(nếu không chỉ rõ thì lớp con sẽ luôn gọi đến constructor mặc định của lớp cha 
 */
 /* Tóm lại: constructor mặc định của con thì gọi mặc định của cha, 
    constructor tham số của con thì gọi constructor có tham số của cha    */
    
 /*
    lớp con chỉ kế thừa non-private attribute, method từ lớp cha. 
    lớp con  muốn lấy private attribute , method thì phải thông qua các
    phương thức non-private của lớp cha như getter, setter.
     */
    
/*
  Đã kế thừa rồi thì lớp con có thể gọi trực tiếp attribute, method của cha mà 
    ko cần super, trừ khi :
    1. gọi constructor của cha
    2. đã ghi đè 1 phương thức của lớp cha và muốn gọi lại phương thức đó
    3. thuộc tính che khuất ( thuộc tính của lớp con bị trùng tên với lớp cha)
    
    super keyword can access non-private fields and methods of the superclass.
*/
    public static void main(String[] args) {
        Student s = new Student();
    }
}
