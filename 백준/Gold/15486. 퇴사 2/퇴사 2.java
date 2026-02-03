import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 
        int[][] arr = new int[N][2]; 
        int[] dp = new int[N + 1]; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            arr[i][0] = Integer.parseInt(st.nextToken()); // term
            arr[i][1] = Integer.parseInt(st.nextToken()); // cost 
        }

        for(int i = N - 1; i >= 0; i--) {
            int nextDay = i + arr[i][0]; 
            if(nextDay < N + 1) {
                dp[i] = Math.max(dp[i + 1], arr[i][1] + dp[nextDay]); 
            } else {
                dp[i] = dp[i + 1]; 
            }                                                                          
        }
              
        bw.write(String.valueOf(dp[0])); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}