package Ass2;

public class O_Node {

    Order info;
    O_Node next;

    public O_Node() {
    }

    public O_Node(Order info, O_Node q) {
        this.info = info;
        this.next = q;
    }

    public O_Node(Order info) {
        this(info, null);
    }
}
