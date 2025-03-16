package DoublyLinkedList;

public class Node {
    Person info;
    Node next;
    Node prev;

    Node() {
    }

    Node(Person x, Node next, Node prev) {
        info = x;
        next = next;
        prev = prev;
    }

    Node(Person x) {
        this(x, null, null);
    }
}
