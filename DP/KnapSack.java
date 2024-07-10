package DP;

public class KnapSack {

    public static int ks(int[] val, int[] wt, int w, int n) { // O(2 ^ n)
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            int ans1 = val[n - 1] + ks(val, wt, w - wt[n - 1], n - 1); // Include weight
            int ans2 = ks(val, wt, w, n - 1); // Exclude weight
            return Math.max(ans1, ans2);
        } else { // Not valid
            return ks(val, wt, w, n - 1);
        }
    }

    public static int ksMemoization(int[] val, int[] wt, int w, int n, int[][] dp) { // O(n * W)
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            int ans1 = val[n - 1] + ksMemoization(val, wt, w - wt[n - 1], n - 1, dp);
            int ans2 = ksMemoization(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {
            dp[n][w] = ksMemoization(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }

    public static int knTabulation(int[] val, int[] wt, int W){
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < W + 1; j++){
                int v = val[i - 1];
                int w = wt[i - 1];
                if(w <= j){
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    dp[i][j] =  dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) { 
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int w = 7;  
        int[][] dp = new int[val.length+1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.print(ks(val, wt, w, val.length));
        // System.out.println(ksMemoization(val, wt, w, val.length, dp));
        // System.out.println(knTabulation(val, wt, w));
    }
}
