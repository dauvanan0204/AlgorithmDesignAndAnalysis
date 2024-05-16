package homework4.excercise2.ex93;

import java.util.*;

// Class to represent a node in the graph
class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class LongestPathWithLargestEdgeWeight {

    // Perform DFS to find the longest path with largest edge weight
    private static void DFS(Map<Integer, List<Node>> graph, int source, int destination,
                            List<Integer> currentPath, int currentMaxWeight, List<Integer> longestPath,
                            int[] visited) {
        visited[source] = 1;
        currentPath.add(source);

        if (source == destination) {
            if (currentMaxWeight > longestPath.get(0)) {
                longestPath.clear();
                longestPath.addAll(currentPath);
                longestPath.set(0, currentMaxWeight);
            }
        } else {
            for (Node neighbor : graph.getOrDefault(source, new ArrayList<>())) {
                if (visited[neighbor.vertex] == 0) {
                    int newMaxWeight = Math.max(currentMaxWeight, neighbor.weight);
                    DFS(graph, neighbor.vertex, destination, currentPath, newMaxWeight, longestPath, visited);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited[source] = 0;
    }

    // Find the longest path with largest edge weight using DFS
    public static List<Integer> findLongestPathWithLargestEdgeWeight(Map<Integer, List<Node>> graph,
                                                                     int source, int destination, int numVertices) {
        List<Integer> longestPath = new ArrayList<>();
        longestPath.add(Integer.MIN_VALUE); // Initialize with smallest possible weight
        List<Integer> currentPath = new ArrayList<>();
        int[] visited = new int[numVertices + 1]; // Array to keep track of visited nodes

        DFS(graph, source, destination, currentPath, Integer.MIN_VALUE, longestPath, visited);

        return longestPath;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example graph represented as adjacency list
        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new Node(2, 5), new Node(3, 10)));
        graph.put(2, Arrays.asList(new Node(3, 8)));
        graph.put(3, Arrays.asList(new Node(4, 7), new Node(5, 6)));

        int source = 1;
        int destination = 5;
        int numVertices = 5;

        List<Integer> longestPath = findLongestPathWithLargestEdgeWeight(graph, source, destination, numVertices);

        if (longestPath.get(0) != Integer.MIN_VALUE) {
            System.out.println("Longest Path with Largest Edge Weight:");
            for (int vertex : longestPath.subList(1, longestPath.size())) {
                System.out.print(vertex + " ");
            }
            System.out.println("\nMaximum Edge Weight: " + longestPath.get(0));
        } else {
            System.out.println("No path exists from source to destination.");
        }
    }
}

