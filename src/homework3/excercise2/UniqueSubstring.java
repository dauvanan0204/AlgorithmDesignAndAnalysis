package homework3.excercise2;

import java.util.Scanner;

public class UniqueSubstring {
    static int minCCount = Integer.MAX_VALUE;

    public static void generateString(int n, String currentString, int index) {
        if (index == n) {
            int cCount = countCharacter(currentString, 'C');
            if (cCount < minCCount) {
                minCCount = cCount;
                System.out.println("Xâu mới tạo: " + currentString);
            }
            return;
        }

        for (char c : new char[]{'A', 'B', 'C'}) {
            if (index == 0 || c != currentString.charAt(index - 1)) {
                generateString(n, currentString + c, index + 1);
            }
        }
    }

    public static int countCharacter(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài của xâu (n < 100): ");
        int n = scanner.nextInt();
        scanner.close();

        if (n >= 100) {
            System.out.println("Độ dài của xâu phải nhỏ hơn 100");
            return;
        }

        minCCount = Integer.MAX_VALUE;
        generateString(n, "", 0);

        System.out.println("Số lượng kí tự C ít nhất: " + minCCount);
    }
}
