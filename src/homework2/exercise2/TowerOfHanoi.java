package homework2.exercise2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of plate: ");
        int n = scanner.nextInt(); // Số đĩa
        char source = 'A', destination = 'C', auxiliary = 'B'; // Tháp nguồn, tháp đích và tháp trung gian
        System.out.println("Tower Of Hanoi By Recursive: ");
        towerOfHanoiRecursive(n, source, destination, auxiliary);
        System.out.println("-----------------------------------------------");
        System.out.println("Tower Of Hanoi non Recursive: ");
        towerOfHanoiIterative(n, source, destination, auxiliary);
        System.out.println("-----------------------------------------------");
        System.out.println("Time no recursive: " + Arrays.toString(timeRunProgramNoRecursive()));
        System.out.println("Time recursive: " + Arrays.toString(timeRunProgramByRecursive()));

    }
    public static long[] timeRunProgramByRecursive() {
        long start, end;
        int[] sizeOfData = {3, 5, 10, 15, 20, 30};
        long[] timeOfRecursive = new long[6];
        for (int i = 0; i < sizeOfData.length; i++) {
            start = System.nanoTime();
            towerOfHanoiRecursive(sizeOfData[i], 'A', 'B', 'C');
            end = System.nanoTime();
            timeOfRecursive[i] = end - start;
        }
        return timeOfRecursive;
    }
    public static long[] timeRunProgramNoRecursive() {
        long start, end;
        int[] sizeOfData = {3, 5, 10, 15, 20, 30};
        long[] timeOfRecursive = new long[6];
        for (int i = 0; i < sizeOfData.length; i++) {
            start = System.nanoTime();
            towerOfHanoiIterative(sizeOfData[i], 'A', 'B', 'C');
            end = System.nanoTime();
            timeOfRecursive[i] = end - start;
        }
        return timeOfRecursive;
    }
    public static void towerOfHanoiRecursive(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        towerOfHanoiRecursive(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        towerOfHanoiRecursive(n - 1, auxiliary, destination, source);
    }

    public static void towerOfHanoiIterative(int n, char source, char destination, char auxiliary) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        // Khởi tạo đĩa vào tháp nguồn
        for (int i = n; i > 0; i--) {
            s1.push(i);
        }

        int totalMoves = (int) Math.pow(2, n) - 1;

        // Di chuyển đĩa từ tháp nguồn sang tháp đích hoặc tháp trung gian theo quy tắc
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisk(s1, s3, source, destination);
            } else if (i % 3 == 2) {
                moveDisk(s1, s2, source, auxiliary);
            } else if (i % 3 == 0) {
                moveDisk(s2, s3, auxiliary, destination);
            }
        }
    }

    public static void moveDisk(Stack<Integer> s1, Stack<Integer> s2, char source, char destination) {
        if (!s1.isEmpty() && (s2.isEmpty() || s1.peek() < s2.peek())) {
            System.out.println("Move disk " + s1.peek() + " from rod " + source + " to rod " + destination);
            s2.push(s1.pop());
        } else if (!s2.isEmpty() && (s1.isEmpty() || s2.peek() < s1.peek())) {
            System.out.println("Move disk " + s2.peek() + " from rod " + destination + " to rod " + source);
            s1.push(s2.pop());
        }
    }
}
