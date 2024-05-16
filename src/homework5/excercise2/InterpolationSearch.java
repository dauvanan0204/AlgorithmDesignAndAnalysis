package homework5.excercise2;

import java.util.Scanner;

public class InterpolationSearch {

    public static int interpolationSearch(int array[], int value) {
        int left = 0;
        int right = array.length - 1;

        while (array[left] != array[right] && value >= array[left] && value <= array[right]) {
            int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);

            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                if (mid > 0 && array[mid - 1] == value) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        if (array[left] == value) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int value = scanner.nextInt();
        System.out.println(interpolationSearch(array, value));
        scanner.close();
    }
}