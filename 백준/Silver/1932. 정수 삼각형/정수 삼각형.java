import java.io.*;
import java.util.*;

public class Main {
    static int n; 
    static int[][] triangle, dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        n = Integer.parseInt(br.readLine()); 
        triangle = new int[n + 1][n + 1]; 
        dp = new int[n + 1][n + 1]; 
        StringTokenizer st; 

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken()); 
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]; 
            }
        }

        int max = 0; 
        for(int i = 1; i <= n; i++) {
            max = Math.max(dp[n][i], max);
        }

        bw.write(String.valueOf(max)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}