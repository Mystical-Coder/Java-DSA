package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RegexPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        int ans = getAns(arr, n, m);

        System.out.println(ans);
    }

    public static int getAns(String[] arr, int n, int m) {
        int count = 0;

        for (int i = 0; i < m; i++) {
            char letter = 0;
            boolean conflict = false;

            for (int j = 0; j < n; j++) {

                char ch = arr[j].charAt(i);

                if (ch == '?') {
                    continue;
                }

                if (letter == 0) {
                    letter = ch;
                } else if (letter != ch) {
                    conflict = true;
                    break;
                }

            }
            if (conflict) {
                count++;
            }
        }

        return count;
    }

}
