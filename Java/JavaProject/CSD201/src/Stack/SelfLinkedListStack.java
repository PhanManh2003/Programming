package Stack;

import java.util.EmptyStackException;

public class SelfLinkedListStack {

    protected Node head;

    public SelfLinkedListStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Person x) {
        head = new Node(x, head);
    }

    public void clear() {
        head = null;
    }

    Person peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // vì là unchecked exception ( runtime exception ) nên ko cần throws
        }
        return head.info;
    }

    public Person pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Person x = head.info;
        head = head.next;
        return x;
    }
}
