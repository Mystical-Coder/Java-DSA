package DP;

import java.util.Arrays;

public class ClimbingStairs {

    public static int countWays(int n){ // O(2^n)
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    public static int countWaysMemoization(int n, int[] dp){ // O(n)
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = countWaysMemoization(n - 1, dp) + countWaysMemoization(n - 2, dp);
        return dp[n];
    }

    public static int countWaysTabulation(int n){ // O(n)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4; // n = 3 -> 3 ways & n = 4 -> 5 ways then n = 5 -> 8 ways
        // System.out.println(countWays(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(countWaysMemoization(n, dp));
        System.out.println(countWaysTabulation(n));
    }
}
