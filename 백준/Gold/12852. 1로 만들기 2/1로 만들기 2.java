import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 

        int[][] dp = new int[N + 1][3]; 
        for(int i = 2; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); 
        }

        if(N >= 2) {
            dp[2][1] = dp[2][0] = 1; 
        }
        if(N >= 3) {
            dp[3][2] = 1; dp[3][0] = 2; 
    
            for(int i = 4; i <= N; i++) {
                dp[i][0] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + 1; 
                if(i % 2 == 0) dp[i][1] = Math.min(Math.min(dp[i / 2][0], dp[i / 2][1]), dp[i / 2][2]) + 1; 
                if(i % 3 == 0) dp[i][2] = Math.min(Math.min(dp[i / 3][0], dp[i / 3][1]), dp[i / 3][2]) + 1; 
            }
        }
        int min = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]); 
        bw.write(min + "\n"); 
        bw.write(printPath(N, dp));
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static String printPath(int N, int[][] dp) {
        StringBuilder sb = new StringBuilder(); 
        int tmp = N; 
        while(tmp != 0) {
            sb.append(tmp).append(" "); 
            
            int min = Math.min(Math.min(dp[tmp][0], dp[tmp][1]), dp[tmp][2]); 
            if(dp[tmp][0] == min) {
                tmp -= 1; 
            } else if (dp[tmp][1] == min) {
                tmp /= 2; 
            } else {
                tmp /= 3; 
            }
        }

        return sb.toString(); 
    }
}