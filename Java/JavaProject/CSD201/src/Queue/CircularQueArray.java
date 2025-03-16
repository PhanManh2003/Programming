package Queue;

/*
Operations on Circular Queue:
1.getFront(): Get the front item from the queue.
2.getRear(): Get the last item from the queue.
3.enqueue(value): To insert an element into the circular queue.
In a circular queue, the new element is always inserted at the rear position. 
4. dequeue(): To delete an element from the circular queue. 
In a circular queue, the element is always deleted from the front position.
5. isEmpty();
6. isFull();
 */
public class CircularQueArray {

    // Circular Queue được triển khai bằng Wrapped Around Array để tận dụng
    private int[] arr;
    private int front;
    private int size; // số phần tử đang có 
    private int capacity;

    public CircularQueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        front = 0;
    }

    // isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull()
    public boolean isFull() {
        return size == capacity;
    }

    // Get the front element
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // Get the rear element
    public int getRear() {
        // Queue is empty
        if (isEmpty()) {
            return -1;
        }
        int rear = (front + (size - 1)) % capacity;
        return arr[rear];
    }

    // Insert an element at the rear
    public void enqueue(int x) {
        // Queue is full   
        if (isFull()) {
            return;
        }
        int rear = (front + size) % capacity;
        arr[rear] = x;
        size++;
    }

    // Remove an element from the front
    public int dequeue() {
        // Queue is empty
        if (isEmpty()) {
            return -1;
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

}
