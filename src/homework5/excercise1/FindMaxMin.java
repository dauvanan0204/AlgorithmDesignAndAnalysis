package homework5.excercise1;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxMin {
    public static void main(String[] args) {
        System.out.print("Input length of array: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.print("Input element of array: ");
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Find min max by Divide and Conquer: ");
        System.out.println(Arrays.toString(minMaxByDC(arr, 0, arr.length - 1)));
        System.out.println("Find min max: ");
        System.out.println(Arrays.toString(findMinMax(arr)));
    }
    public static int[] findMinMax(int[] arr) {
        int max = arr[0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int[]{min, max};
    }
    public static int[] minMaxByDC(int[] arr, int left, int right) {
        int min;
        int max;
        int[] minMaxArr = new int[2];
        int[] minMaxArr1 = new int[2];
        int[] minMaxArr2 = new int[2];
        if(right - left <= 1) {
            minMaxArr[0] = Math.min(arr[left], arr[right]);
            minMaxArr[1] = Math.max(arr[left], arr[right]);
            return minMaxArr;
        } else {
            minMaxArr1 = minMaxByDC(arr, left, left + right / 2);
            minMaxArr2 = minMaxByDC(arr, (left + right) / 2 + 1, right);
            min = Math.min(minMaxArr1[0], minMaxArr2[0]);
            max = Math.max(minMaxArr1[1], minMaxArr2[1]);
            return new int[]{min, max};
        }
    }
}
