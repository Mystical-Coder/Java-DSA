package DP;

/**
 * CoinChange
 */
public class CoinChange {

    public static int change(int[] coins, int sum) { // O(n * sum)
        int[][] dp = new int[coins.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int sum = 4; // ans = 4
        // int[] coins = {2, 5, 3, 6};
        // int sum = 10;
        // System.out.println(change(coins, sum));
        // int[] coins = {1, 2, 5};
        // int sum = 11;
        System.out.println(change(coins, sum));
    }
}