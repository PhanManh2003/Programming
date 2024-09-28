package Graph_traverse_dijkstra_eulerCycle;

class EulerCycle {

    int[] e;
    int m;
    char[] v;

    EulerCycle() {
        e = new int[50];
        m = 0;
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void add(int x) {
        e[m++] = x;
    }

    void display() {
        for (int i = 0; i < m - 1; i++) {
            System.out.print(v[e[i]] + " -> ");
        }
        System.out.println(v[e[m - 1]]);
    }
}
