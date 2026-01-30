import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 
        bw.write(String.valueOf(solution(N))); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static long solution(int n) {
        if(n == 1) return 1; 
        long[][] dp = new long[n + 1][2]; 
        
        dp[1][1] = 1; 

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; 
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1]; 
        }
        
        return dp[n][0] + dp[n][1]; 
    }
}