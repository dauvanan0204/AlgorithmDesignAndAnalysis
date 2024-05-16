package homework3.excercise1;

public class KnightTour {
    static int N = 8;

    // Kiểm tra xem x, y có là chỉ số hợp lệ cho bàn cờ kích thước N x N không
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // In ra lời giải
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    // Hàm giải quyết bài toán Knight Tour bằng phương pháp backtracking
    static boolean solveKT() {
        int sol[][] = new int[8][8];

        // Khởi tạo ma trận lời giải
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        // Các bước di chuyển của quân mã
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Quân mã xuất phát từ ô đầu tiên
        sol[0][0] = 0;

        // Bắt đầu từ ô (0,0) và thử tất cả các lời giải có thể
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    // Hàm đệ quy giúp giải quyết bài toán Knight Tour
    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        // Thử tất cả các bước di chuyển tiếp theo từ vị trí hiện tại (x, y)
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtrack
            }
        }

        return false;
    }

    // Hàm main
    public static void main(String args[]) {
        // Gọi hàm giải quyết bài toán
        solveKT();
    }
}
