package Ass1;

public class P_Node {

    Product info;
    P_Node next;

    public P_Node() {
    }

    public P_Node(Product info, P_Node q) {
        this.info = info;
        this.next = q;
    }

    public P_Node(Product info) {
        this(info, null);
    }

}
