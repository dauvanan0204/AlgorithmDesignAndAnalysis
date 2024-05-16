package homework6.exercise1;

public class CountingCombinationProblem {
    public static void main(String[] args) {
        int r = 5;
        int n = 10;
        // Create a 2D array with (r + 1) rows and (n + 1) columns
        int[][] C = new int[r + 1][n + 1];

        // Initialize the diagonals to 1 (when row index and column index are the same)
        for (int i = 0; i <= r; i++) {
            C[i][i] = 1;
        }

        // Initialize the first row to 1
        for (int i = 0; i <= n; i++) {
            C[0][i] = 1;
        }

        // Fill the Pascal's Triangle
        for (int i = 1; i <= r; i++) {
            for (int j = i + 1; j <= n; j++) {
                // C[i][j] is the sum of the previous row, previous column and current column
                C[i][j] = C[i - 1][j - 1] + C[i][j - 1];
            }
        }

        // Display the results in a formatted way for visualization
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
