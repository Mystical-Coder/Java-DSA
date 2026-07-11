package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BoosterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] power_a = new int[n];
        int[] power_b = new int[n];
        int[] power_c = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            power_a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            power_b[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            power_c[i] = Integer.parseInt(st.nextToken());
        }

        int ans = getAns(power_a, power_b, power_c, n);

        System.out.println(ans);
    }

    public static int getAns(int[] power_a, int[] power_b, int[] power_c, int n) {
        int ans = 0;

        int[] s1 = new int[n];
        int[] s2 = new int[n];
        int[] s3 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] arr = { power_a[i], power_b[i], power_c[i] };

            Arrays.sort(arr);

            s1[i] = arr[0];
            s2[i] = arr[1];
            s3[i] = arr[2];
        }

        int maxS1 = Integer.MIN_VALUE, smaxs1 = Integer.MIN_VALUE, maxIdxS1 = -1;
        int maxS2 = Integer.MIN_VALUE, smaxs2 = Integer.MIN_VALUE, maxIdxS2 = -1;

        for (int i = 0; i < n; i++) {
            if (s1[i] > maxS1) {
                smaxs1 = maxS1;
                maxS1 = s1[i];
                maxIdxS1 = i;
            } else if (s1[i] > smaxs1) {
                smaxs1 = s1[i];
            }

            if (s2[i] > maxS2) {
                smaxs2 = maxS2;
                maxS2 = s2[i];
                maxIdxS2 = i;
            } else if (s2[i] > smaxs2) {
                smaxs2 = s2[i];
            }

        }

        for (int i = 0; i < n; i++) {
            int maxOtherS1 = (i == maxIdxS1) ? smaxs1 : maxS1;
            int maxOtherS2 = (i == maxIdxS2) ? smaxs2 : maxS2;

            if (s2[i] > maxOtherS1 && s3[i] > maxOtherS2) {
                ans++;
            }
        }
        return ans;
    }

}
