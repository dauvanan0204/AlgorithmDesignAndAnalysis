package homework6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "acbaed";
        String str2 = "abcadf";

        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the LCS lengths
        int[][] result = new int[m + 1][n + 1];

        // Build the LCS array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }

        // Extract the LCS
        List<Character> choose = new ArrayList<>();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (result[i][j] == result[i - 1][j - 1] + 1) {
                choose.add(0, str1.charAt(i - 1)); // Insert at the beginning
                i--;
                j--;
            } else if (result[i][j] == result[i - 1][j]) {
                i--; // Move up in the result array
            } else {
                j--; // Move left in the result array
            }
        }

        // Print the LCS
        System.out.print("Longest Common Subsequence: ");
        for (char c : choose) {
            System.out.print(c);
        }
    }
}

