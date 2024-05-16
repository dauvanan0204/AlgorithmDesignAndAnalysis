package homework2.exercise2;

import java.util.Scanner;

public class Dec2Bin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input decimal number: ");
        int number = scanner.nextInt();
        System.out.print("Binary number by recursive : ");
        System.out.println(decToBinByRecursive(number));
        System.out.print("Binary number : ");
        System.out.println(decToBin(number));
    }
    public static String decToBinByRecursive(int number) {
        if (number == 0) return "";
        return decToBinByRecursive(number / 2) + String.valueOf(number % 2);
    }
    public static String decToBin(int number) {
        StringBuilder binary = new StringBuilder();

        // Thực hiện phép chia và lấy dư cho đến khi kết quả nguyên bằng 0
        while (number > 0) {
            int remainder = number % 2; // Lấy phần dư
            binary.insert(0, remainder); // Chèn phần dư vào đầu chuỗi
            number /= 2; // Cập nhật số hệ thập phân bằng kết quả nguyên của phép chia
        }

        return binary.toString();
    }
}
