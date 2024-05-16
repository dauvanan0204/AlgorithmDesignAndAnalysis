package homework4.excercise2.ex92;

import java.util.*;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Compare edges based on their weights
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(other.weight, this.weight);
    }
}

// Class to represent a subset for union-find
class Subset {
    int parent, rank;

    Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class MaximumSpanningTree {

    // Find operation for union-find
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Union operation for union-find
    private void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    // Function to find the maximum spanning tree using Kruskal's algorithm
    public List<Edge> findMaximumSpanningTree(List<Edge> edges, int numVertices) {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        Subset[] subsets = new Subset[numVertices];
        for (int i = 0; i < numVertices; i++) {
            subsets[i] = new Subset(i, 0);
        }

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < numVertices - 1 && index < edges.size()) {
            Edge nextEdge = edges.get(index++);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                mst.add(nextEdge);
                union(subsets, x, y);
                edgeCount++;
            }
        }

        return mst;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(0, 2, 10));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 7));
        edges.add(new Edge(2, 3, 6));

        int numVertices = 4;

        MaximumSpanningTree mstFinder = new MaximumSpanningTree();
        List<Edge> mst = mstFinder.findMaximumSpanningTree(edges, numVertices);

        System.out.println("Maximum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }
}

