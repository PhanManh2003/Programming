package slot4;

import java.lang.StringBuilder;

public class StringBuilderGuide {

    public StringBuilderGuide(String hello) {
    }
//StringBuilder is a class in Java that is used to create mutable (modifiable)
//   sequences of characters. Unlike String, which is immutable, StringBuilder 
//       can be modified after it is created,

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // append
//        sb.append("Java");//now original string is changed  
//        System.out.println(sb);//prints Hello Java  
        // insert
//        sb.insert(1, "Java");//now original string is changed  
//        System.out.println(sb);//prints HJavaello  
        // replace
//        sb.replace(1, 3, "Java");
//        System.out.println(sb);//prints HJavalo  
        // delete
//        sb.delete(1, 3);
//        System.out.println(sb);//prints Hlo  

        // reverse
        sb.reverse();
        System.out.println(sb);//prints olleH  
    }

}
