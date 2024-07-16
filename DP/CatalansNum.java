package DP;

import java.util.Arrays;

public class CatalansNum {

    public static int getCat(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += getCat(i) * getCat(n - i - 1);
        }
        return ans;
    }

    public static int getCatMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += getCat(i) * getCat(n - i - 1);
        }
        return dp[n] = ans; 
    }

    public static int getCatTabulation(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4; // 14
        // int n = 5; // 42
        // int n = 30; // Take alot of time
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(getCat(n));
        // System.out.println(getCatMemoization(n, dp));
        System.out.println(getCatTabulation(n));
    }
}
