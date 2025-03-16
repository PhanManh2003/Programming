package Queue;


public class SimpleQueArray {

    int[] items;
    int front, rear, size;

    SimpleQueArray() {
        this(10);
    }

    public SimpleQueArray(int size) {
        this.size = size;
        items = new int[size];
        front = rear = -1;
    }

    boolean isFull() {
        return rear == size - 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */ else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return element;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            return items[front];
        }
    }

    void display() {
        /* Function to display elements of Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++) {
                System.out.print(items[i] + "  ");
            }

            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        SimpleQueArray q = new SimpleQueArray(5);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);
        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();

    }
}
