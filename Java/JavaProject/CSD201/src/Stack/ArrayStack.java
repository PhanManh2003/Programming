package Stack;

import java.util.EmptyStackException;

public class ArrayStack {

    private Object[] a;
    private int top;
    private int size;

    public ArrayStack() {
        this(50);
    }

    public ArrayStack(int size) {
        this.size = size;
        this.a = new Object[size];
        this.top = -1;
    }

    // top+ 1 là số lượng phần tử sao chép, biến top ko cần cập nhật vì nó vẫn đang trỏ vào vị trí phần tử cuối cùng của stack
    private boolean grow() {
        int newMax = size + size / 2;
        Object[] newArray = new Object[newMax];
        System.arraycopy(a, 0, newArray, 0, top + 1);
        a = newArray;
        size = newMax;
        return true;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void clear() {
        top = -1;
    }

    public void push(Object x) {
        if (isFull()) {
            grow();
        }
        top++;
        a[top] = x;
    }

    public Object top() {
        // hoặc gọi là peek cũng dc
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return a[top];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = a[top];
        top--;
        return x;
    }
}
