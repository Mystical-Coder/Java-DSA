package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class TotalDistDiff {
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

        long ans = 0;

        Stack<Integer> stack = new Stack<>();
        HashSet<Long> set = new HashSet<>();

        for (int val : arr) {

            while (!stack.isEmpty() && stack.peek() < val) {
                set.add((long) val - stack.peek());
                stack.pop();
            }

            if (!stack.isEmpty()) {
                set.add((long) stack.peek() - val);
            }
            stack.push(val);
        }

        for(long s : set){
            ans += s;
        }

        return ans;
    }

}
