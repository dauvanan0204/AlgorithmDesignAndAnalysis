package homework3.excercise2;

import java.util.ArrayList;

public class CombinationGenerator {
    public static ArrayList<ArrayList<Integer>> generateCombinations(int n, int k) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(combinations, current, 1, n, k);
        return combinations;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(combinations, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 7; // Số lượng phần tử từ 1 đến n
        int k = 3; // Số lượng phần tử trong mỗi tổ hợp

        ArrayList<ArrayList<Integer>> combinations = generateCombinations(n, k);

        System.out.println("Generated combinations:");
        for (ArrayList<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

