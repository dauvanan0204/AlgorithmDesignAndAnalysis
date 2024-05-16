package homework1.exercise1.turingm4;

import homework1.exercise1.turingm3.TransferFunction;

import java.util.Scanner;

public class TuringM4 {
    private TransferFunction transferFunction = new TransferFunction();

    public String action(String binaryString) {
        StringBuilder res = new StringBuilder();
        int length = binaryString.length();
        for (int i = 0; i < length; i++) {
            res.append(turingMachine(binaryString.charAt(i)));
            System.out.println("State: " + transferFunction);
            System.out.println(res);
        }
        return res.toString();
    }

    private Character turingMachine(Character readSymbol) {
        switch (readSymbol) {
            case '*':
                return '*';
            case '#':
                transferFunction.setWriteSymbol('#');
                transferFunction.setDirection("_");
                return '#';
            default:
                Character writeSymbol = readSymbol == '1' ? '1' : ' ';
                transferFunction.setWriteSymbol(writeSymbol);
                return writeSymbol;
        }
    }
    public static void main(String[] args) {
        TuringM4 turingMachine = new TuringM4();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input binary string: ");
        String input = scanner.next();

        System.out.println("Input: " + input);

        String output = turingMachine.action('*' + input + '#');

        print(output.trim());

        scanner.close();
    }

    private static void print(String output) {
        int length = output.length();

        System.out.print("Output: ");
        for (int i = 1; i < length - 1; i++) {
            Character currentChar = output.charAt(i);
            if (currentChar == ' ') {
                continue;
            }
            System.out.print(currentChar);
        }
    }
        //    Input binary string: 01001
        //    Input: 01001
        //    State: (s, *, ->)
        //            *
        //    State: (s,  , ->)
        //            *
        //    State: (s, 1, ->)
        //            * 1
        //    State: (s,  , ->)
        //            * 1
        //    State: (s,  , ->)
        //            * 1
        //    State: (s, 1, ->)
        //            * 1  1
        //    State: (s, #, _)
        //            * 1  1#
        //    Output: 11
}
