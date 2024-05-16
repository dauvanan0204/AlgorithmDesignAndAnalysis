package homework6.exercise2;

import java.util.Arrays;
import java.util.List;

/*Input: sum = 4, coins[] = {1,2,3},
        Output: 4
        Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.
*/
public class CoinChangeProblem {
    static int count(List<Integer> coins, int n, int sum) {
        // 2D dp array where n is the number of coin
        // denominations and sum is the target sum
        int[][] dp = new int[n + 1][sum + 1];

        // Represents the base case where the target sum is 0,
        // and there is only one way to make change: by not
        // selecting any coin
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Add the number of ways to make change without
                // using the current coin
                dp[i][j] += dp[i - 1][j];

                if ((j - coins.get(i - 1)) >= 0) {
                    // Add the number of ways to make change
                    // using the current coin
                    dp[i][j] += dp[i][j - coins.get(i - 1)];
                }
            }
        }
        return dp[n][sum];
    }

    // Driver Code
    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 2, 3);
        int n = 3;
        int sum = 5;
        System.out.println(count(coins, n, sum));
    }
}
