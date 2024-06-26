import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 5;
        double b = 3;
        System.out.println((a / b));
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
