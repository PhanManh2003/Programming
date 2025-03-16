package List;

import java.util.LinkedList;

/*
 Java LinkedList class can contain duplicate elements.
 Java LinkedList class maintains insertion order.
 Java LinkedList class is non synchronized.
 In Java LinkedList class, manipulation is fast because no shifting needs to occur.
But direct access takes O(n), worse than ArrayList
 Java LinkedList class can be used as a list, stack or queue
 */

/*
1. boolean add(Object o)
2. void add(int index, Object element) ( của List interface)
3. void addFirst(E e)
4. void addLast(E e)
5. E get(int index), E getFirst(), E getLast()
6. E peek(), E peekFirst(), E peekLast() : retrieve
7. E poll(), E pollFirst(), E pollLast(): retrieve and remove
8. E pop(), void push(E e)
9. E removeFirst(), E removeLast()
*/
public class LinkedList_ {

    public static void main(String[] args) {
        // Constructor 1: Create an empty LinkedList
        LinkedList<String> list1 = new LinkedList<>();

        // Constructor 2: Create a LinkedList from another collection
        LinkedList<String> list2 = new LinkedList<>(list1);

        // Adding elements to the LinkedList
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println("Initial LinkedList: " + list1);

        // Add elements at specific positions
        list1.addFirst("First");
        list1.addLast("Last");
        System.out.println("After addFirst and addLast: " + list1);

        // Accessing elements
        System.out.println("Element at index 2: " + list1.get(2));
        System.out.println("First element: " + list1.getFirst());
        System.out.println("Last element: " + list1.getLast());

        // Peeking elements ( retrieve first/last)
        System.out.println("Peek: " + list1.peek());
        System.out.println("Peek First: " + list1.peekFirst());
        System.out.println("Peek Last: " + list1.peekLast());

        // Polling elements (retrieve first/last and remove, if not return null)
        System.out.println("Poll: " + list1.poll());
        System.out.println("Poll First: " + list1.pollFirst());
        System.out.println("Poll Last: " + list1.pollLast());
        System.out.println("After polling: " + list1);

        // Using push and pop (head of the list is used for LIFO of stack)
        list1.push("New First");
        System.out.println("After push: " + list1);
        System.out.println("Popped element: " + list1.pop());
        System.out.println("After pop: " + list1);

        // Removing elements
        System.out.println("Removed First: " + list1.removeFirst());
        System.out.println("Removed Last: " + list1.removeLast());
        System.out.println("After removeFirst and removeLast: " + list1);

    }
}
