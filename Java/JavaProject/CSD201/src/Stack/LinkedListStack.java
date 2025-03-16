package Stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack {

    private LinkedList<Person> h;

    public LinkedListStack() {
        h = new LinkedList<>();
    }

    public boolean isEmpty() {
        return h.isEmpty();
    }

    public void push(Person x) {
        h.add(x);
    }

    Person peek() {
        if (isEmpty()) {
            return null;
        }
        return h.getLast();
    }

    Person pop() {
        if (isEmpty()) {
            return null;
        }
        return h.removeLast();
    }

    public void clear() {
        h.clear();
    }

}
