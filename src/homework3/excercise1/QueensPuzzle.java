package homework3.excercise1;

import java.util.Scanner;

public class QueensPuzzle {
    int n;
    int[] cols;

    public QueensPuzzle(int n) {
        this.n = n;
        cols = new int[n];
    }

    public void solve() {
        if (placeQueens(0)) {
            printQueens();
        } else {
            System.out.println("Không có giải pháp cho bài toán");
        }
    }

    private boolean placeQueens(int row) {
        if (row == n) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            cols[row] = col;
            if (isValid(row)) {
                if (placeQueens(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (cols[row] == cols[i] || (row - i) == Math.abs(cols[row] - cols[i])) {
                return false;
            }
        }
        return true;
    }

    private void printQueens() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (cols[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        QueensPuzzle queensPuzzle = new QueensPuzzle(8);
        queensPuzzle.solve();
        queensPuzzle.printQueens();
    }
}
