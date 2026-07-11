package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class OutlierDetection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = getAns(arr, n);
        System.out.println(ans);
    }

    public static int getAns(int[] arr, int n) {

        int ans = Integer.MIN_VALUE;

        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            sum += a;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int a : arr) {
            int remaining = sum - a;

            if (remaining % 2 != 0) {
                continue;
            }

            int ele = remaining / 2;

            if (!map.containsKey(ele)) {
                continue;
            }

            if (ele == a) {
                if (map.get(ele) >= 2) {
                    ans = Math.max(ans, a);
                }
            } else {
                ans = Math.max(ans, a);
            }
        }
        return ans;
    }

}
