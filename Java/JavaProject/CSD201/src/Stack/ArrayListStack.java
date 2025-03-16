package Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack {

    private ArrayList<Person> h;

    public ArrayListStack() {
        h = new ArrayList<>();
    }

    public boolean isEmpty() {
        return h.isEmpty();
    }

    public void clear() {
        h.clear();
    }

    public void push(Person x) {
        h.add(x);
    }

    Person peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return h.get(h.size() - 1);
    }

    Person pop() {
        if (isEmpty()) {
            return null;
        }
        return h.remove(h.size() - 1);
    }
}
