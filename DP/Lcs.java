package DP;

public class Lcs {

    public static int getLCS(String str1, String str2, int n, int m) { // O(2^N)
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // If equal
            return getLCS(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = getLCS(str1, str2, n - 1, m);
            int ans2 = getLCS(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int getLCSDp(String str1, String str2, int n, int m, int[][] dp) { // O(n * m)
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = getLCSDp(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = getLCSDp(str1, str2, n - 1, m, dp);
            int ans2 = getLCSDp(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static int getLCSTabulation(String str1, String str2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        // System.out.println(getLCS(str1, str2, str1.length(), str2.length()));
        // int[][] dp = new int[str1.length() + 1][str1.length() + 1];
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        System.out.println(getLCSTabulation(str1, str2, str1.length(), str2.length()));
    }
}
