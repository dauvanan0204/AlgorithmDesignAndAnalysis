package homework4.excercise1;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeCoins {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input money: ");
        int money = scanner.nextInt();
        System.out.print("Input length of coins: ");
        int length = scanner.nextInt();
        System.out.print("Input coins: ");
        int[] coins = new int[length];
        for (int i = 0; i < length; i++) {
            coins[i] = scanner.nextInt();
        }
        sort(coins);
        System.out.println(Arrays.toString(changeCoins(coins, money)));
//        Input money: 55
//        Input length of coins: 3
//        Input coins: 10 6 1
//                [5, 0, 5]

//        Input money: 78
//        Input length of coins: 4
//        Input coins: 50 10 5 1
//                [1, 2, 1, 3]

//        Input money: 62
//        Input length of coins: 3
//        Input coins: 50 4 10
//        Exception in thread "main" java.lang.Exception: No solution!
    }
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] < array[j]){
                    swap(array, j - 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] changeCoins(int[] coins, int money) throws Exception {
        int[] greedySolution = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            greedySolution[i] = 0;
        }
        int i = 0;
        while (i <= coins.length - 1 && money > 0) {
            greedySolution[i] = money / coins[i];
            money -= greedySolution[i] * coins[i];
            i += 1;
        }
        if (money > 0) {
            throw new Exception("No solution!");
        } else {
            return greedySolution;
        }
    }
}
