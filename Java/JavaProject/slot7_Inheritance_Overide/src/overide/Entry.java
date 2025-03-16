package overide;

public class Entry {

/*
phương thức static sẽ không thể bị ghi đè và 
đối với các phương thức non-static bạn có thể 
ngăn không cho lớp con ghi đè bằng cách thêm từ khóa final giống như sau: 
    public final void display(){...};
*/
    
/*
Để ghi đè phương thức của lớp cha thì phương thức của lớp con phải có
phạm vi truy cập bằng hoặc rộng hơn phạm vị truy cập của phương thức ở lớp cha. 
*/
    

 
    public static void main(String[] args) {
        Student s = new Student("Trung", "Male", 1700);
        s.display();
    }
}
