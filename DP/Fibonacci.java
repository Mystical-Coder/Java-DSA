package DP;

public class Fibonacci {

    public static int fib(int[] f, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fib(f, n - 1) + fib(f, n - 2);
        return f[n];
    }

    public static int fibTabulation(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];  
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        // System.out.print(n);
        System.out.print(fibTabulation(n));
    }

}