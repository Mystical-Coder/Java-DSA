package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AmazonAcedmy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            long sum = 0, prev = 0;
            for(int i = n - 1; i >= 0; i--){
                prev += arr[i];
                sum += prev;
            }
            System.out.println(sum);
        }

    }
}
