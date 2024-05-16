package homework5.excercise2;

public class Fibonacci {

    // Hàm tính toán số Fibonacci của n sử dụng chia để trị
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long[] memo = new long[n + 1];
        return fibonacciHelper(n, memo);
    }

    private static long fibonacciHelper(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }

        // Nếu đã tính toán số Fibonacci của n trước đó, trả về giá trị từ bộ nhớ đệm
        if (memo[n] != 0) {
            return memo[n];
        }

        // Tính số Fibonacci của n bằng cách chia thành các bài toán con nhỏ hơn
        long fib = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);

        // Lưu kết quả vào bộ nhớ đệm
        memo[n] = fib;

        return fib;
    }

    public static void main(String[] args) {
        int n = 10; // Ví dụ tính số Fibonacci thứ 10
        long result = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is " + result);
    }
}

