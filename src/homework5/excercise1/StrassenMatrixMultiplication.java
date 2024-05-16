package homework5.excercise1;

public class StrassenMatrixMultiplication {

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];

        // Base case: if the input matrices are 1x1
        if (n == 1) {
            result[0][0] = A[0][0] * B[0][0];
        } else {
            // Divide the matrices into submatrices
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];

            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            splitMatrix(A, A11, 0, 0);
            splitMatrix(A, A12, 0, n / 2);
            splitMatrix(A, A21, n / 2, 0);
            splitMatrix(A, A22, n / 2, n / 2);

            splitMatrix(B, B11, 0, 0);
            splitMatrix(B, B12, 0, n / 2);
            splitMatrix(B, B21, n / 2, 0);
            splitMatrix(B, B22, n / 2, n / 2);

            // Strassen's algorithm steps
            int[][] P1 = multiply(add(A11, A22), add(B11, B22));
            int[][] P2 = multiply(add(A21, A22), B11);
            int[][] P3 = multiply(A11, subtract(B12, B22));
            int[][] P4 = multiply(A22, subtract(B21, B11));
            int[][] P5 = multiply(add(A11, A12), B22);
            int[][] P6 = multiply(subtract(A21, A11), add(B11, B12));
            int[][] P7 = multiply(subtract(A12, A22), add(B21, B22));

            // Computing result submatrices
            int[][] C11 = add(subtract(add(P1, P4), P5), P7);
            int[][] C12 = add(P3, P5);
            int[][] C21 = add(P2, P4);
            int[][] C22 = add(subtract(add(P1, P3), P2), P6);

            // Combining submatrices into the result matrix
            joinMatrix(C11, result, 0, 0);
            joinMatrix(C12, result, 0, n / 2);
            joinMatrix(C21, result, n / 2, 0);
            joinMatrix(C22, result, n / 2, n / 2);
        }

        return result;
    }

    // Helper method to add two matrices
    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // Helper method to subtract two matrices
    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    // Helper method to split a matrix into quadrants
    private static void splitMatrix(int[][] parent, int[][] child, int startRow, int startCol) {
        for (int i1 = 0, i2 = startRow; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = startCol; j1 < child.length; j1++, j2++) {
                child[i1][j1] = parent[i2][j2];
            }
        }
    }

    // Helper method to join a quadrant matrix into a parent matrix
    private static void joinMatrix(int[][] child, int[][] parent, int startRow, int startCol) {
        for (int i1 = 0, i2 = startRow; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = startCol; j1 < child.length; j1++, j2++) {
                parent[i2][j2] = child[i1][j1];
            }
        }
    }

    // Helper method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    public static int[][] multiplyMatrix(int[][] A, int[][] B, int n) {
        // TODO Auto-generated method stub
        if (A == null || B == null) {
            return null;
        }

        int[][] multiplyMatrix = new int[n][n];

        int product = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < B.length; h++) {
                    product = product + (A[i][h] * B[h][j]);
                }
                multiplyMatrix[i][j] = product;
                product = 0;
            }
        }
        return multiplyMatrix;

    }

    public static void main(String[] args) {
//        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] B = {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}};
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{1,2},{3,4}};
        int[][] result = multiply(A, B);
        int[][] result1 = multiplyMatrix(A, B, 2);
        System.out.println("Resultant Matrix:");
        printMatrix(result);
        printMatrix(result1);
    }
}

