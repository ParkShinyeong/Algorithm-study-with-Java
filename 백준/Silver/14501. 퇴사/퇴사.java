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
            for(int j = i + arr[i][0]; j <= N; j++) {
                dp[i] = Math.max(arr[i][1] + dp[j], dp[i]); 
            }                                                                            
        }
        
        int max = 0; 
        for(int i = 0; i < N; i++) {
            max = Math.max(dp[i], max); 
        }
        bw.write(String.valueOf(max)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}