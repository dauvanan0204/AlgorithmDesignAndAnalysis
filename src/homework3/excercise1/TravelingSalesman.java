package homework3.excercise1;

import java.util.Arrays;

public class TravelingSalesman {
    private int n;
    private int[][] graph;
    private boolean[] visited;
    private int[] bestPath;
    private int bestCost;
    private int startCity;

    public TravelingSalesman(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.visited = new boolean[n];
        this.bestPath = new int[n + 1]; // Chứa lộ trình tốt nhất
        this.bestCost = Integer.MAX_VALUE;
        this.startCity = 0; // Thành phố xuất phát (ở đây lấy là 0)
    }

    public void solve() {
        visited[startCity] = true; // Đánh dấu thành phố xuất phát đã được đi qua
        bestPath[0] = startCity;
        tryPath(1, 0); // Gọi hàm đệ quy để thử các lựa chọn
    }

    private void tryPath(int step, int costSoFar) {
        if (step == n) { // Nếu đã đi qua tất cả các thành phố
            if (graph[bestPath[n - 1]][startCity] != 0) { // Nếu có thể quay trở lại thành phố xuất phát
                int totalCost = costSoFar + graph[bestPath[n - 1]][startCity]; // Tính tổng chi phí
                if (totalCost < bestCost) { // Nếu tổng chi phí tốt hơn chi phí tốt nhất hiện tại
                    bestCost = totalCost; // Cập nhật chi phí tốt nhất
                    bestPath[n] = startCity; // Thêm thành phố xuất phát vào cuối lộ trình
                    System.arraycopy(bestPath, 0, bestPath, 0, n + 1); // Sao chép lộ trình vào lộ trình tốt nhất
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[bestPath[step - 1]][i] != 0) { // Nếu thành phố chưa được đi qua và có thể đi từ thành phố trước đó
                    visited[i] = true; // Đánh dấu thành phố đã được đi qua
                    bestPath[step] = i; // Thêm thành phố vào lộ trình
                    tryPath(step + 1, costSoFar + graph[bestPath[step - 1]][i]); // Thử các lựa chọn tiếp theo
                    visited[i] = false; // Bỏ đánh dấu đã đi qua thành phố
                }
            }
        }
    }

    public void printBestPath() {
        System.out.println("Best Path:");
        for (int i = 0; i < n; i++) {
            System.out.print(bestPath[i] + " -> ");
        }
        System.out.println(bestPath[n] + " (Cost: " + bestCost + ")");
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        TravelingSalesman salesman = new TravelingSalesman(graph);
        salesman.solve();
        salesman.printBestPath();
    }
}

