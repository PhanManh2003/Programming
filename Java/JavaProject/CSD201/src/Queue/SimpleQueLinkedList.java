package Queue;

public class SimpleQueLinkedList {

    private Node front, rear;

    public SimpleQueLinkedList() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Person x) { // giống addLast
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // deque luôn trả về giá trị của node ( giống removeFirst)
    public Person dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Person x = front.info;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return x;
    }

    public Person peek() {
        if (isEmpty()) {
            return null;
        }
        return front.info;

    }
}
