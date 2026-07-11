package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AmazonParcel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int exrta = Integer.parseInt(br.readLine());

        long ans = getAns(arr, exrta);

        System.out.println(ans);

    }

    public static long getAns(int[] arr, int exrta) {
        long low = Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;
        for (int val : arr) {
            low = Math.max(low, val);
            high = Math.max(high, val);
        }

        high += exrta;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long totalPoint = checkDist(arr, mid, exrta);

            if (totalPoint >= exrta) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static long checkDist(int[] arr, long dist, long exrta) {
        long totalPoint = 0;

        for (int val : arr) {
            if (val < dist) {
                totalPoint += (dist - val);
            }
            if (totalPoint >= exrta) {
                break;
            }
        }
        return totalPoint;
    }

}