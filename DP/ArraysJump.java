package DP;

import java.util.Arrays;

public class ArraysJump {

    public static int minJumps(int[] arr) {
        int[] dp = new int[arr.length];
        int n = dp.length;
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int step = arr[i];
            for (int j = i + 1; j <= i + step && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(minJumps(nums));
    }
}
