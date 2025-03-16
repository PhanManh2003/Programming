package DoublyLinkedList;

/*

 */
public class MyDoublyList {

    Node head, tail;

    public MyDoublyList() {
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

    void traverseReverse() {
        Node p = tail;
        while (p != null) {
            visit(p);
            p = p.prev;
        }
        System.out.println();
    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    // INSERT AND SEARCH
    void addLast(Person x) {
        Node q = new Node(x); // prev , next is null
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        q.prev = tail;
        tail = q;
    }

    void addFirst(Person x) {
        Node newNode = new Node(x);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return null;
    }

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return (p);
            }
            p = p.next;
        }
        return null;
    }

    void insertAfter(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = q.next;
        newNode.prev = q;
        // cat mat xich cu
        if (q.next != null) {
            q.next.prev = newNode;
        }
        q.next = newNode;
        if (q == tail) {
            tail = newNode;
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

    // REMOVE
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) { // danh sach co 1 phan tu
            tail = null;
        } else {
            head.prev = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            return;
        }
        if (tail.prev == null) { // danh sach co 1 phan tu
            head = tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
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
        if (p == null) {  // ko tìm thấy q
            return;
        }

        Node qNext = q.next;
        p.next = qNext;
        if (qNext == null) {
            tail = p;
        } else {
            qNext.prev = p;
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

    void removeAll(String xName) {
        Node q;
        while (true) {
            q = searchByName(xName);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // Return a node at index k
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
        return null;
    }

    void removeAtPosition(int k) {
        Node q = pos(k);
        remove(q);
    }

    // SORT: Selection sort
    void sortByName() {
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

    // GET ARRAY OF DATA
    Person[] toArray() {
        int i = 0;
        int n = size();
        Person x;
        Person[] a = new Person[n];
        Node p = head;
        while (p != null) {
            x = new Person(p.info.name, p.info.age);
            a[i] = x;
            i++;
            p = p.next;
        }
        return (a);
    }
}
