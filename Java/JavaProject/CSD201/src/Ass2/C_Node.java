package Ass2;

public class C_Node {

    Customer info;
    C_Node next;

    public C_Node() {
    }

    public C_Node(Customer info, C_Node next) {
        this.info = info;
        this.next = next;
    }

    public C_Node(Customer info) {
        this(info, null);
    }
}
