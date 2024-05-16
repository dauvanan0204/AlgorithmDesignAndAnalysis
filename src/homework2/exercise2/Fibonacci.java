package homework2.exercise2;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        System.out.println("Fibonacci of " + number + " is: " + fibonacciRecursive(number));
        System.out.println("Fibonacci of " + number + " is: " + fibonacciIterative(number));
        System.out.println("Time no recursive: " + Arrays.toString(timeRunProgramNoRecursive()));
        System.out.println("Time recursive: " + Arrays.toString(timeRunProgramByRecursive()));

    }
    public static long[] timeRunProgramByRecursive() {
        long start, end;
        int[] sizeOfData = {1, 10, 20, 30, 40, 45};
        long[] timeOfRecursive = new long[6];
        for (int i = 0; i < sizeOfData.length; i++) {
            start = System.nanoTime();
            fibonacciRecursive(sizeOfData[i]);
            end = System.nanoTime();
            timeOfRecursive[i] = end - start;
        }
        return timeOfRecursive;
    }
    public static long[] timeRunProgramNoRecursive() {
        long start, end;
        int[] sizeOfData = {1, 10, 20, 30, 40, 45};
        long[] timeOfRecursive = new long[6];
        for (int i = 0; i < sizeOfData.length; i++) {
            start = System.nanoTime();
            fibonacciIterative(sizeOfData[i]);
            end = System.nanoTime();
            timeOfRecursive[i] = end - start;
        }
        return timeOfRecursive;
    }
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;
        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}

