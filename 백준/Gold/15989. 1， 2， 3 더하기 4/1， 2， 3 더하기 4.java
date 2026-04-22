import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new int[10_001][3 + 1]; 
        dp[0][1] = 1; 
        fillDp(); 

        int T = Integer.parseInt(br.readLine()); 
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); 
            bw.write(getTotal(n, 3) + "\n"); 
        }
        
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void fillDp() {
        for(int i = 1; i <= 10000; i++) {
            dp[i][1] = 1; 
            if(i - 2 >= 0) dp[i][2] = getTotal(i - 2, 2); 
            if(i - 3 >= 0) dp[i][3] = getTotal(i - 3, 3); 
        }
    }


    private static int getTotal(int n, int cnt) {
        int sum = 0; 
        for(int i = 1; i <= cnt; i++) {
            sum += dp[n][i]; 
        }
        return sum; 
    }
}