package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AmazonWareHouse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = getAns(arr, n);

        System.out.println(ans);

    }

    public static long getAns(int[] arr, int n) {
        long sum = 0;
        for (int a : arr) {
            sum += a;
        }

        long low = sum / n;
        long high = low + 1;
        int r = (int) (sum % n);

        long operation = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n - r; i++) {
            if (arr[i] < low) {
                operation += (low - arr[i]);
            }
        }

        for (int i = n - r; i < n; i++) {
            if (arr[i] < high) {
                operation += (high - arr[i]);
            }
        }
        return operation;
    }

}