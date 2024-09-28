package Ass2;

import java.util.*;

public class MyQueue {

    LinkedList<P_Node> t;

    MyQueue() {
        t = new LinkedList<>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(P_Node p) {
        t.addLast(p);
    }

    P_Node dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    P_Node front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
