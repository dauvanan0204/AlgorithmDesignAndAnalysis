package homework5.excercise1;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.print("Input element of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array, 0, n - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;
        int[] b = new int[n];
        int left = low, right = mid + 1, bIdx = 0;

        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
                b[bIdx++] = array[left++];
            } else {
                b[bIdx++] = array[right++];
            }
        }
        while (left <= mid) {
            b[bIdx++] = array[left++];
        }
        while (right <= high) {
            b[bIdx++] = array[right++];
        }
        for (int k = 0; k < n; k++) {
            array[low + k] = b[k];
        }
    }
    public static void sort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
}

