package Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ServerClient {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        
        int[] centre = new int[n];
        int[] destination = new int[n];
        
        for(int i = 0; i < n; i++){
            centre[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            destination[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(centre);
        Arrays.sort(destination);

        

    }
}
