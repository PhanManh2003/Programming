package Graph_traverse_dijkstra_eulerCycle;

public class Main {

    public static void main(String[] args) {
        // 1. TEST TRAVERSAL
//        int[][] b = {
//            {0, 1, 1, 0, 0, 0},
//            {1, 0, 0, 1, 0, 0},
//            {1, 0, 0, 0, 0, 0},
//            {0, 1, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 1},
//            {0, 0, 0, 0, 1, 0}
//        };
//        Graph g = new Graph();
//        g.setData(b);
//        g.dispAdj();
//        System.out.println();
//        System.out.println("1. Test breadth-first traversal:");
//        g.breadth(0); // A B C D E F
//        System.out.println();
//        System.out.println("2. Test depth-first traversal:");
//        g.depth(0); // A B D C E F
//        System.out.println("\n");

        // 2. TEST DIJKSTRA
//        int[][] b = {
//            {0, 7, 9, 99, 99, 14},
//            {7, 0, 10, 15, 99, 99},
//            {9, 10, 0, 11, 99, 2},
//            {99, 15, 11, 0, 6, 99},
//            {99, 99, 99, 6, 0, 9},
//            {14, 99, 2, 99, 9, 0}
//        };
//        Graph g = new Graph();
//        g.setData(b);
//        System.out.println("1. Display adjacency matrix:");
//        g.dispAdj();
//        System.out.println();
//        System.out.println("2. Test Dijkatra's shortest path algorithm:");
//        g.dijkstra(0, 4);
//        System.out.println();

        // 3. TEST EULER CYCLE
        int[][] b = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 2},
            {0, 1, 0, 1, 2},
            {1, 0, 1, 0, 0},
            {0, 2, 2, 0, 0}
        };
        Graph g = new Graph();
        g.setData(b);
        System.out.println("\n1. Display adjacency matrix:");
        g.dispAdj();
        System.out.println("\n2. Test finding Euler Cycle:");
        EulerCycle t;
        t = g.findEulerCycle(0);
        t.display(); // A -> D -> C -> E -> B -> E -> C -> B -> A
        System.out.println();
    }
}
