package Graph_traverse_dijkstra_eulerCycle;

public class Graph {

    int[][] a;
    int n;
    char v[];

    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.format("%5d", a[i][j]);
            }
        }
    }

    void visit(int i) {
        System.out.print(v[i] + " ");
    }

    // Hàm breadth(boolean[] en, int i) để duyệt đỉnh i và các đỉnh được kết nối với nó
    void breadth(boolean[] en, int i) {
        MyQueue q = new MyQueue();
//        Đẩy đỉnh i vào queue và đánh dấu nó là đã thăm (en[i] = true).
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            int r = q.dequeue();
            visit(r);
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
//            Trong khi hàng đợi không rỗng:
//- Lấy ra đỉnh đầu tiên trong hàng đợi (r = q.dequeue()).
//- Thực hiện hành động "visit" trên đỉnh đó (hàm visit(r)).
//- Duyệt qua tất cả các đỉnh của đồ thị (j = 0 đến j < n):
//  Nếu đỉnh chưa được thăm (!en[j]) và có liên kết từ đỉnh hiện tại (a[r][j] > 0), 
//  thì đẩy nó vào hàng đợi và đánh dấu là đã thăm (q.enqueue(j)).
        }
    }

    void breadth(int k) {
        //k: Đỉnh bắt đầu cho BFS.
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);

        // Nếu các đỉnh chưa được thăm (!en[i]), gọi breadth(en, i) để tiếp tục BFS từ đỉnh đó.
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
    }

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }

    void depth(int k) {
        boolean[] vis = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            vis[i] = false;
        }

        depth(vis, k);
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                breadth(vis, i);
            }
        }
    }

    // DIJKSTRA
    
   /* 
    DijkstraAlgorithm(non-gegative weighted simple digraph, vertex first):
for all vertices  v # first currDist(v) = INF;
currDist(first) = 0;
toBeChecked = V (all vertices);
checked = empty;
while toBeChecked is not empty:
    // Step 1:  Tìm nút có khoảng cách ngắn nhất từ gốc trong các nút chưa thuộc S
    u = a vertex in toBeChecked with min.currDist(u);
    remove u from toBeChecked and add to checked;
    // Step 2: Cập nhật khoảng cách từ nút bắt đầu đến các nút khác
    for all vertices v adjacent to u and in toBeChecked:
        if (currDist(v) > currDist(u) + weight(edge(uv)))
        {currDist(v) = currDist(u) + weight(edge(uv))
         predeccessor(v) = u;
        }
*/

    
    
    void dijkstra(int fro, int to) {
        // S: Mảng boolean giữ các nút đã được chọn vào tập hợp S
        // d: Mảng lưu giữ khoảng cách ngắn nhất từ nút bắt đầu đến các nút khác
        // p: Mảng theo dõi nút trước đó trong đường đi ngắn nhất
        // INF: Hằng số để đại diện cho giá trị vô cực
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int INF = 99; // Giá trị đại diện cho khoảng cách rất lớn (vô cực)
        int i, j, k, t;

        // Khởi tạo d và p với giá trị từ nút bắt đầu đến các nút khác
        for (i = 0; i < n; i++) {
            S[i] = false; // Tập hợp S ban đầu là rỗng
            d[i] = a[fro][i]; // Khoảng cách ban đầu từ nút bắt đầu đến các nút khác
            p[i] = fro; // Tất cả các nút trước đó là nút bắt đầu
        }
        S[fro] = true; // Chọn nút bắt đầu vào tập hợp S       
        while (true) {
            //B1: Tìm nút k có khoảng cách ngắn nhất trong các nút chưa thuộc S
            t = INF;
            k = -1; // Lưu giữ nút có khoảng cách ngắn nhất
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue; // Bỏ qua các nút đã nằm trong S
                }
                if (d[i] < t) { // Tìm nút có khoảng cách ngắn nhất
                    t = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                break; // Nếu không còn nút nào, kết thúc
            }
            S[k] = true; // Chọn nút k vào tập hợp S
            if (k == to) { // Nếu nút k là nút kết thúc, dừng lại
                break;
            }
            //B2: Cập nhật khoảng cách từ nút bắt đầu đến các nút khác
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue; // Bỏ qua các nút đã thuộc S
                }
                if (d[i] > d[k] + a[k][i]) { // Nếu tìm được đường đi ngắn hơn
                    d[i] = d[k] + a[k][i]; // Cập nhật khoảng cách
                    p[i] = k; // Cập nhật nút trước đó
                }
            }
        }

        // In khoảng cách ngắn nhất từ nút bắt đầu đến nút kết thúc
        System.out.println("The shortest distance is " + d[to]);

        // Dùng stack để in đường đi ngắn nhất từ nút bắt đầu đến nút kết thúc
        MyStack s = new MyStack();
        i = to;
        s.push(i);
        while (i != fro) { // Đẩy các nút vào stack để lấy theo thứ tự ngược lại
            i = p[i];
            s.push(i);
        }

        System.out.println("The shortest path is: ");
        i = s.pop(); // In nút đầu tiên

        System.out.print(i);
        while (!s.isEmpty()) { // In các nút còn lại trong stack
            i = s.pop();
            System.out.print(" -> " + i);
        }
    }

    // Euler Cycle 
    boolean isDirected() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return (true);
                }
            }
        }
        return (false);
    }

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        if (a[i][i] > 0) {
            s += a[i][i];
        }
        return (s);
    }

    boolean isConnected() {
        MyStack s = new MyStack();
        boolean[] p = new boolean[n];
        int i, j, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }

    boolean isEvenDegree() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 != 0) {
                return (false);
            }
        }
        return (true);
    }

    boolean hasIsolatedVertex() {
        for (int i = 0; i < n; i++) {
            if (deg(i) == 0) {
                return (true);
            }
        }
        return (false);
    }

    EulerCycle findEulerCycle(int k) {
        if (isDirected() || !isConnected() || !isEvenDegree() || hasIsolatedVertex()) {
            System.out.println(" The conditions for Euler Cycle are not satisfied");
            return (null);
        }
        MyStack s = new MyStack();
        int[][] b = new int[n][n]; 
        int i, j, r;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = a[i][j];  // Backup original adjacency matrix
            }
        }
        EulerCycle t = new EulerCycle();
        s.push(k); // Start the cycle from vertex k
        while (!s.isEmpty()) {
            r = s.top();
            i = 0;
            while (i < n && a[r][i] == 0) {
                i++;
            }
            if (i == n) { // The vertex r is now isolated
                r = s.pop();
                t.add(r);
            } else {
                s.push(i);
                a[r][i]--; // Xóa cạnh
                a[i][r]--;
            }
        }
        setData(b);  // Restore the original graph matrix a[n][n]
        return (t);
    }
}
