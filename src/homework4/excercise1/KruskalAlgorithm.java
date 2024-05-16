package homework4.excercise1;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalAlgorithm {
    private int V; // Số đỉnh của đồ thị
    private List<Edge> edges; // Danh sách các cạnh của đồ thị

    public KruskalAlgorithm(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    private int findParent(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return findParent(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int xset = findParent(parent, x);
        int yset = findParent(parent, y);
        parent[xset] = yset;
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V]; // Để lưu trữ các cạnh của cây bao trùm tối thiểu
        int e = 0; // Index của cạnh trong cây bao trùm tối thiểu đã tìm được
        int i = 0; // Index của cạnh được xem xét trong danh sách các cạnh đã sắp xếp

        edges.sort(null); // Sắp xếp các cạnh theo trọng số tăng dần

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i);
            i++;

            int x = findParent(parent, nextEdge.src);
            int y = findParent(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Minimal Spanning Tree:");
        int totalWeight = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            totalWeight += result[i].weight;
        }
        System.out.println("Total Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm(7);
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 2, 8);
        graph.addEdge(3, 4, 15);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 6, 9);
        graph.addEdge(5, 6, 11);

        graph.kruskalMST();
    }
}

