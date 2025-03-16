package CircularLinkedList;

public class MyCircularList {

    Node head, tail;

    public MyCircularList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    int size() {
        int i = 0;
        if (isEmpty()) {
            return 0;
        }
        Node p = head;
        do {
            i++;
            p = p.next;
        } while (p != head);
        return i;
    }

    // INSERT AND SEARCH
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            q.next = head; // Linking the last node to the head to form a circle
            return;
        }
        tail.next = q;
        tail = q;
        tail.next = head; // Maintaining the circular connection
    }

    void addFirst(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            q.next = head;
        } else {
            q.next = head;
            head = q;
            tail.next = head; // Ensure the tail still points to head
        }
    }

}
