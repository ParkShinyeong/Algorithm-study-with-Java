import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int[] arr = new int[N]; 
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        int[] dp = new int[N]; 
        Arrays.fill(dp, 1);
        int[] prev = new int[N]; 
        Arrays.fill(prev, -1); 

        for(int i = 0; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1; 
                    prev[i] = j; 
                }
            }
        }

        int maxCnt = 0; 
        int maxIdx = 0; 

        for(int i = 0; i < N; i++) {
            if(maxCnt < dp[i]) {
                maxCnt = dp[i]; 
                maxIdx = i; 
            }
        }

        bw.write(maxCnt + "\n"); 

        int tmp = maxIdx; 
        String answer = ""; 
        while(tmp != -1) {
            answer = arr[tmp] + " " + answer; 
            tmp = prev[tmp]; 
        }
        bw.write(answer); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}