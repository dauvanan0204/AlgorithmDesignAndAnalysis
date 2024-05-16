package homework5.excercise1;

public class HouseTiling {

    public static void main(String[] args) {
        int n = 2; // Kích thước của nền nhà là 2^n × 2^n
        int[][] house = new int[(int) Math.pow(2, n)][(int) Math.pow(2, n)];
        int[] escape = {0, 0}; // Vị trí ô thoát nước

        tileHouse(house, escape, 0, 0, house.length, 1);

        // In kết quả
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                if (i == escape[0] && j == escape[1]) {
                    System.out.print("E\t"); // Ô thoát nước
                } else {
                    System.out.print(house[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // Hàm đệ quy để xếp gạch
    private static void tileHouse(int[][] house, int[] escape, int row, int col, int size, int tileNum) {
        if (size == 2) {
            // Xác định vị trí ô thoát nước
            if (row == escape[0] && col == escape[1]) {
                house[row][col] = 0;
                house[row][col + 1] = tileNum;
                house[row + 1][col] = tileNum;
            } else {
                house[row][col] = tileNum;
                house[row][col + 1] = tileNum;
                house[row + 1][col] = tileNum;
            }
        } else {
            int newSize = size / 2;
            int midRow = row + newSize;
            int midCol = col + newSize;

            int nextTileNum = tileNum + 1;

            // Bốn phần tử hình chữ L
            tileHouse(house, escape, row, col, newSize, tileNum);
            tileHouse(house, escape, row, midCol, newSize, tileNum);
            tileHouse(house, escape, midRow, col, newSize, tileNum);
            tileHouse(house, escape, midRow, midCol, newSize, nextTileNum);
        }
    }
}

