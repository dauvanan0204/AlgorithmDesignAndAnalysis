package homework1.exercise1.turingm2;

import homework1.exercise1.turingm3.TransferFunction;

import java.util.Scanner;

public class TuringM2 {
    private TransferFunction transferFunction = new TransferFunction();

    public String action(String binaryString) {
        StringBuilder res = new StringBuilder();
        int length = binaryString.length();
        boolean subtractOne = true; // Flag to indicate if subtraction by 1 is needed

        for (int i = length - 1; i >= 0; i--) {
            char currentSymbol = binaryString.charAt(i);
            char resultSymbol = turingMachine(currentSymbol, subtractOne);
            res.insert(0, resultSymbol); // Insert result from right to left

            // Reset subtractOne flag if the current symbol is '1'
            if (subtractOne && currentSymbol == '1') {
                subtractOne = false;
            }
            System.out.println("State: " + transferFunction);
            System.out.println(res);
        }
        return res.toString();
    }

    private char turingMachine(char readSymbol, boolean subtractOne) {
        switch (readSymbol) {
            case '0':
                if (subtractOne) {
                    transferFunction.setWriteSymbol('1');
                } else {
                    transferFunction.setWriteSymbol('0');
                }
                transferFunction.setDirection("->");
                return transferFunction.getWriteSymbol();
            case '1':
                if (subtractOne) {
                    transferFunction.setWriteSymbol('0');
                } else {
                    transferFunction.setWriteSymbol('1');
                }
                transferFunction.setDirection("->");
                return transferFunction.getWriteSymbol();
            default:
                return readSymbol; // No change for other symbols
        }
    }

    public static void main(String[] args) {
        TuringM2 turingMachine = new TuringM2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi nhị phân: ");
        String input = scanner.next();

        System.out.println("Input: " + input);

        String output = turingMachine.action(input);

        print(output);

        scanner.close();
    }

    private static void print(String output) {
        System.out.println("Output: " + output);
        //        Nhập chuỗi nhị phân: 101
        //        Input: 101
        //        State: (s, 0, ->)
        //        0
        //        State: (s, 0, ->)
        //        00
        //        State: (s, 1, ->)
        //        100
        //        Output: 100
    }
}

