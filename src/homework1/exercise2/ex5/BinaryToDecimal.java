package homework1.exercise2.ex5;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        int decimal = binaryToDecimal(binaryString);
        System.out.println("Decimal equivalent: " + decimal);
    }
    public static int binaryToDecimal(String binaryString) {
        int decimal = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(binaryString.charAt(i));
            decimal = decimal * 2 + digit;
        }
        return decimal;
    }
}
