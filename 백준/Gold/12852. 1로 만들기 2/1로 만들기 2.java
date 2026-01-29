import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 

        int[] dp = new int[N + 1]; 
        int[] path = new int[N + 1]; 
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0] = dp[1] = 0; 

        for(int i = 2; i <= N; i++) {
            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1; 
                path[i] = i / 3; 
            } 
            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1; 
                path[i] = i / 2; 
            }
            if(dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1; 
                path[i] = i - 1; 
            }
        }
        bw.write(dp[N] + "\n"); 

        int tmp = N; 
        while(tmp != 0) {
            bw.write(tmp + " "); 
            tmp = path[tmp]; 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}