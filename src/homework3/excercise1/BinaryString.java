package homework3.excercise1;

import java.util.Scanner;

public class BinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfBin = scanner.nextInt();
        generateBinaryStrings("", lengthOfBin);
    }

    public static void generateBinaryStrings(String current, int length) {
        if (current.length() == length) {
            System.out.println(current); // Print the generated binary string
            return;
        }
        generateBinaryStrings(current + "0", length); // Append '0' and proceed
        generateBinaryStrings(current + "1", length); // Append '1' and proceed
    }
}
