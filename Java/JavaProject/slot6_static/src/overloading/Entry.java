 
package overloading;

/**
 * overload methods have same name but different parameter.
 * There are two ways to overload the method in java:
    - By changing number of arguments
    - By changing the data type
 * Overload can change the return type/ access modifier if needed
 * 
 * A method can be overloaded in a class or in a subclass.
 */ 

public class Entry {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
        Student s2 = new Student("Quang");
        s2.display();
        Student s3 = new Student('m');
        s3.display();
        Student s4 = new Student("Thu", 'f');
        s4.display();
    }
}
