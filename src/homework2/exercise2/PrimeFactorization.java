package homework2.exercise2;

import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        System.out.print("Prime factors by recursive of " + number + " are: ");
        primeFactorization(number);
        System.out.print("\nPrime factors no recursive of " + number + " are: ");
        primeFactorNoRecursive(number);
    }

    public static void primeFactorization(int n) {
        // Bắt đầu từ số nguyên tố nhỏ nhất là 2
        primeFactorizationRecursive(n, 2);
    }

    public static void primeFactorizationRecursive(int n, int divisor) {
        // Nếu số cần phân tích nhỏ hơn hoặc bằng 1 thì dừng lại
        if (n <= 1) return;

        // Nếu số cần phân tích chia hết cho divisor thì in ra divisor và tiếp tục phân tích n / divisor
        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            primeFactorizationRecursive(n / divisor, divisor);
        }
        // Ngược lại, tăng divisor lên 1 và tiếp tục đệ quy
        else {
            primeFactorizationRecursive(n, divisor + 1);
        }
    }
    public static void primeFactorNoRecursive(int n) {
        // Lặp qua tất cả các số nguyên tố từ 2 đến căn bậc hai của n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // Kiểm tra i có phải là thừa số nguyên tố của n không
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        // Nếu n là số nguyên tố lớn hơn 2
        if (n > 2) {
            System.out.print(n);
        }
    }
}

