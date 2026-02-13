import java.io.*;

public class Main {
    static long[] dp = new long[1_000_001]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 4; 
        int T = Integer.parseInt(br.readLine()); 

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long answer = solution(n); 
            bw.write(answer + "\n");
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static long solution(int n) {
        if(dp[n] != 0) return dp[n]; 
        return dp[n] = (solution(n - 1) + solution(n - 2) + solution(n - 3)) % 1_000_000_009; 
    }
}