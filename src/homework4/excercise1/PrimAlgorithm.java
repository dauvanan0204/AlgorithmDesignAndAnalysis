package homework4.excercise1;

import java.util.Arrays;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static int[][] primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V]; // Lưu trữ cây bao trùm tối thiểu
        int[] key = new int[V]; // Để lưu trữ trọng số nhỏ nhất của cạnh nối từ cây hiện tại đến đỉnh chưa thăm
        boolean[] visited = new boolean[V]; // Đánh dấu các đỉnh đã thăm

        Arrays.fill(key, INF); // Khởi tạo các khóa là vô cùng

        key[0] = 0; // Chọn đỉnh 0 làm đỉnh xuất phát
        parent[0] = -1; // Đỉnh 0 là đỉnh gốc

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, visited); // Chọn đỉnh có khóa nhỏ nhất chưa thăm
            visited[u] = true; // Đánh dấu đỉnh đã thăm

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Xây dựng ma trận kề của cây bao trùm tối thiểu
        int[][] mst = new int[V][V];
        for (int i = 1; i < V; i++) {
            mst[i][parent[i]] = graph[i][parent[i]];
            mst[parent[i]][i] = graph[i][parent[i]];
        }

        return mst;
    }

    private static int minKey(int[] key, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, 0, 5, 0, 0, 0},
                {7, 0, 8, 9, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0},
                {5, 9, 0, 0, 15, 6, 0},
                {0, 7, 5, 15, 0, 8, 9},
                {0, 0, 0, 6, 8, 0, 11},
                {0, 0, 0, 0, 9, 11, 0}
        };

        int[][] mst = primMST(graph);

        // In ra cây bao trùm tối thiểu
        System.out.println("Minimal Spanning Tree:");
        for (int i = 0; i < mst.length; i++) {
            for (int j = 0; j < mst[i].length; j++) {
                if (mst[i][j] != 0) {
                    System.out.println(i + " - " + j + " : " + mst[i][j]);
                }
            }
        }
    }
}
