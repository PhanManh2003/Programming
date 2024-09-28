package testBSTree_Person;

public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      String [] a = {"A","B","C","D","E","F","G","H","I"};
      int [] b = {8,3,10,1,6,14,4,7,13};
      t.insertMany(a,b);
      System.out.println("1. Test breadth-first traversal");
      t.breadth(t.root); // (A,8)  (B,3)  (C,10)  (D,1)  (E,6)  (F,14)  (G,4)  (H,7)  (I,13)
      System.out.println();
      System.out.println("2. Test pre-order traversal");
      t.preOrder(t.root); // (A,8)  (B,3)  (D,1)  (E,6)  (G,4)  (H,7)  (C,10)  (F,14)  (I,13)
      System.out.println();
      System.out.println("3. Test in-order traversal");
      t.inOrder(t.root); // (D,1)  (B,3)  (G,4)  (E,6)  (H,7)  (A,8)  (C,10)  (I,13)  (F,14)
      System.out.println();
      System.out.println("4. Test post-order traversal");
      t.postOrder(t.root); // (D,1)  (G,4)  (H,7)  (E,6)  (B,3)  (I,13)  (F,14)  (C,10)  (A,8)
      System.out.println();
    }
    
}
