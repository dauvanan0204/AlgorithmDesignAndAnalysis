package homework1.exercise2.ex3;

import java.util.Scanner;

public class TriangleArea {
    public static double areaCalculator(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of sides");

        System.out.print("a = ");
        double a = scanner.nextDouble();

        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");

        double c = scanner.nextDouble();

        System.out.println("Area = " + areaCalculator(a, b, c));

        scanner.close();
    }
}
