package LinkedList_sol;

public class MyList {

    // Khi thực hiện THÊM, SỬA, XÓA xong thì phải đặt lại biến head, tail nếu cần
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) Add , visit , traverse
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addFirst(Person x) {
        head = new Node(x, head); // head trong Node(x,head) là head cũ
        if (tail == null) {
            tail = head;
        }
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

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2) Search
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3) Insert
    void insertAfter(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    void insertBefore(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        insertAfter(p, x);
    }

    // (4) Remove
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void remove(Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        Node q1 = q.next;
        p.next = q1;
        if (p.next == null) {
            tail = p;
        }
    }

    void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }

    void remove(int xAge) {
        Node q = searchByAge(xAge);
        remove(q);
    }

    void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByAge(xAge);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // (5): Trả về 1 node ở vị trí k: Chú ý là trả về con trỏ đến Node chứ ko phải trả về bản sao của Node
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    // (6): Sorting
    void sortByName() { // BubbleSort , không phải SelectionSort
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    void sortByAge() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // (7) length of linkedList
    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    // (8) Lấy mảng Person
    Person[] toArray() {
        int i, n;
        Person x;
        n = size();
        Person[] a = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            x = new Person(p.info.name, p.info.age);
            a[i++] = x;
            p = p.next;
        }
        return (a);
    }

    // (9) Đảo ngược 
    void reverse() {
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(new Person(p.info.name, p.info.age));
            p = p.next;
        }
        head = t.head;
        tail = t.tail;
    }

    // (10) Min , Max
    Node findMaxAge() {
        if (isEmpty()) {
            return (null);
        }
        int x; // x là max age
        Node p, q;
        p = head;
        q = p; // q là Node có max age
        x = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age > x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    Node findMinAge() {
        if (isEmpty()) {
            return (null);
        }
        int x;
        Node p, q;
        p = head;
        q = p;
        x = head.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age < x) {
                x = p.info.age;
                q = p;
            }
            p = p.next;
        }
        return (q);
    }

    // (11)  Others
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // Sort from k to h
    void sortByAge(int k, int h) {
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node u, v;
        u = pos(k);
        v = pos(h + 1);
        Node pi, pj;
        Person x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    // reverse from k to h 
    void reverse(int k, int h) {
        if (k > h) {
            return;
        }
        int n, i, j;
        n = size();
        if (k < 0 || h > n - 1) {
            return;
        }
        Person[] a = toArray();
        i = k;
        j = h;
        Person x;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }
}
