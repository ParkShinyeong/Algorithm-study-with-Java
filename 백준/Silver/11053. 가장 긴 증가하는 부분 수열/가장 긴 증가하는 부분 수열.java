import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int[] dp = new int[N]; 
        Arrays.fill(dp, 1); 

        int max = 0; 

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 

            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]); 
            }
            max = Math.max(dp[i], max); 
        }
        bw.write(max + "");
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}