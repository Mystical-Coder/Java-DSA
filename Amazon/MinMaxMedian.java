package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinMaxMedian {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = getAns(arr, n, k);

        System.out.println(list);
    }

    public static ArrayList<Integer> getAns(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(arr);

        int m = (k - 1) / 2;

        int min = arr[m];

        int max = arr[n - k + m];
        
        ans.add(max);

        ans.add(min);
        
        return ans;
    }

}