import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); 
        int num = 10; 
        int sub = 1_000_000_000; 

        int[][] dp = new int[N + 1][num];
        
        Arrays.fill(dp[1], 1); 
        dp[1][0] = 0; 

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < num; j++) {
                if(j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % sub; 
                if(j < num - 1) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % sub; 
            }
        }

        int total = 0; 
        for(int i = 0; i < num; i++) {
            total = (total + dp[N][i]) % sub; 
        }
        bw.write(String.valueOf(total));
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}