import java.io.*;

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

    static int solution(int N) { 
        if(N == 1) return 1; 
        int[] dp = new int[N + 1]; 
        dp[1] = 1; 
        dp[2] = 3; 

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007; 
        }  
        
        return dp[N]; 
    }
}