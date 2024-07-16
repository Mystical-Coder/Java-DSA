package DP;

public class CatalansNum {

    public static int getCat(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += getCat(n) * getCat(n - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(getCat(n));
    }
}
