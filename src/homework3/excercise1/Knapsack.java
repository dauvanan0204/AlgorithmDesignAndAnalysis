package homework3.excercise1;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    static int[] w = {2, 3, 2 , 5, 3}; // Trọng lượng của các đồ vật
    static double[] v = {40, 50, 100, 95, 30}; // Giá trị của các đồ vật
    static int M = 10; // Trọng lượng tối đa của cái túi
    static int n = w.length; // Số lượng các đồ vật
    static double best = 0; // Giá trị tốt nhất tìm được
    static double cost = 0; // Giá trị tạm thời của các đồ vật được chọn
    static int weight = 0; // Trọng lượng tạm thời của các đồ vật được chọn
    static int[] x = new int[M / Arrays.stream(w).min().getAsInt() + 1]; // Mảng lưu các đồ vật được chọn (chỉ lưu index)
    static ArrayList<Integer> items = new ArrayList<>(); // Mảng lưu các đồ vật được chọn (lưu trọng lượng và giá trị)

    public static void main(String[] args) {
        branchBound(1);
        System.out.println("Best value: " + best);
        System.out.print("Items chosen: ");
        for (int item : items) {
            System.out.print(item + " ");
        }
    }

    static void branchBound(int i) {
        for (int j = 0; j < n; j++) {
            if (weight + w[j] <= M) {
                x[i] = j;
                cost += v[j];
                weight += w[j];
                if (weight + Arrays.stream(w).min().getAsInt() > M) {
                    if (cost > best) {
                        best = cost;
                        items.clear();
                        for (int k = 1; k <= i; k++) {
                            items.add(x[k]);
                        }
                    }
                } else {
                    if (cost + (M - weight) / Arrays.stream(w).min().getAsInt() * 3 > best) {
                        branchBound(i + 1);
                    }
                }
                cost -= v[j];
                weight -= w[j];
            }
        }
    }
}
