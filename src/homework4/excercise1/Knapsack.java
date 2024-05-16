package homework4.excercise1;

import java.util.*;

public class Knapsack {

    public static void greedyKnapsack01(int T, int[] w, int[] v) {
        int n = w.length;
        Map<Integer, Double> dictUnits = new HashMap<>();
        int[] result = new int[n];
        double[] units = new double[n];

        for (int i = 0; i < n; i++) {
            units[i] = (double) v[i] / w[i];
            dictUnits.put(i, units[i]);
        }

        List<Map.Entry<Integer, Double>> sortedDictUnits = new ArrayList<>(dictUnits.entrySet());
        Collections.sort(sortedDictUnits, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });

        int i = 0;
        while (T > 0 && i < n) {
            if (T >= w[sortedDictUnits.get(i).getKey()]) {
                result[sortedDictUnits.get(i).getKey()] = 1;
                T -= w[sortedDictUnits.get(i).getKey()];
            }
            i++;
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] w = {10, 3, 3, 10, 6};
        int[] v = {5, 3, 6, 15, 1};
        int T = 20;
        greedyKnapsack01(T, w, v);
    }
}
