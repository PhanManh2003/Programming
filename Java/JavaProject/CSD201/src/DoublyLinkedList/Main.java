package DoublyLinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyDoublyList doublyList = new MyDoublyList();
        String[] a = {"A", "C", "B", "E", "D"};
        int[] b = {9, 5, 17, 5, 8};
//        System.out.println("\n1. Test addFirst");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        Person x = new Person("X", 30);
//        doublyList.addFirst(x);
//        doublyList.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)
//---------------------------------------------------------------------------
//        System.out.println("\n2. Test addLast");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        Person x = new Person("X", 30);
//        doublyList.addLast(x);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8) (X,30)
//---------------------------------------------------------------------------
//        System.out.println("\n3. Test Insert After");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        Node q = doublyList.searchByName("B");
//        Person x = new Person("X", 30);
//        doublyList.insertAfter(q, x);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (X,30) (E,5) (D,8) 
//---------------------------------------------------------------------------
//        System.out.println("\n4. Test Insert Before");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        Node q = doublyList.searchByName("B");
//        Person x = new Person("X", 30);
//        doublyList.insertBefore(q, x);
//        doublyList.traverse(); //  (A,9) (C,5) (X,30) (B,17) (E,5) (D,8) 
//---------------------------------------------------------------------------
//        System.out.println("\n5. Test Remove First");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//      
//        doublyList.removeFirst();
//        doublyList.traverse(); //  (C,5) (B,17) (E,5) (D,8) 
//---------------------------------------------------------------------------
//        System.out.println("\n6. Test Remove Last");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        doublyList.removeLast();
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5)
//---------------------------------------------------------------------------
//        System.out.println("\n7. Test Remove A Node");
//        doublyList.clear();
//        doublyList.addMany(a, b);
//        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
//        doublyList.remove(doublyList.searchByName("B"));
//        doublyList.traverse(); //  (A,9) (C,5) (E,5) (D,8)
//---------------------------------------------------------------------------
        System.out.println("\n8. Test Remove All Person C");
        doublyList.clear();
        doublyList.addMany(a, b);
        doublyList.addLast(new Person("C", 15));
        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8) (C,15)
        doublyList.removeAll("C");
        doublyList.traverse(); //  (A,9) (B,17) (E,5) (D,8)
        System.out.println(doublyList.size());
//---------------------------------------------------------------------------
        System.out.println("\n9. Test Remove At Position k");
        doublyList.clear();
        doublyList.addMany(a, b);
        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8) 
        doublyList.removeAtPosition(1);
        doublyList.traverse(); //  (A,9) (B,17) (E,5) (D,8)
//---------------------------------------------------------------------------
        System.out.println("\n10. Sort by Name");
        doublyList.clear();
        doublyList.addMany(a, b);
        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8) 
        doublyList.sortByName();
        doublyList.traverse(); //  (A,9) (B,17) (C,5) (D,8) (E,5) 
//---------------------------------------------------------------------------
        System.out.println("\n10. GET ARRAY OF DATA");
        doublyList.clear();
        doublyList.addMany(a, b);
        doublyList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8) 
        Person[] people = doublyList.toArray();
        System.out.println(Arrays.toString(people));


    }
}
