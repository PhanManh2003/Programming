 
package overide;
 /*
Khi cần sử dụng super:
1.	Constructor:
Khi muốn gọi constructor của lớp cha từ trong constructor của lớp con, bạn phải sử dụng super(). 

2.	Phương thức ghi đè (Override):
	Khi bạn ghi đè một phương thức của lớp cha trong lớp con, phương thức của lớp con sẽ thay thế phương thức của lớp cha khi được gọi trên đối tượng của lớp con.
	Nếu bạn vẫn muốn gọi phương thức của lớp cha từ trong phương thức đã ghi đè, bạn phải sử dụng super.methodName().

3.	Thuộc tính che khuất (Shadowed attributes):
Khi lớp con khai báo một thuộc tính có cùng tên với một thuộc tính của lớp cha, thuộc tính của lớp con sẽ che khuất thuộc tính của lớp cha.
	Để truy cập thuộc tính của lớp cha trong trường hợp này, bạn phải sử dụng super.attributeName.


*/
public class Super {
    
}
