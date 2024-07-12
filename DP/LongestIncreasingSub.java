package DP;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LongestIncreasingSub {

    public static int lcs(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public static int getLIS(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int[] arr2 = new int[set.size()];
        int i = 0;
        for (int val : set) {
            arr2[i] = val;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {
        int[] arr = { 50, 3, 10, 7, 40, 80 };
        System.out.println(getLIS(arr));
    }
}
