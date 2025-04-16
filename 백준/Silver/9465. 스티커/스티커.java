import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st; 
        int T = Integer.parseInt(br.readLine()); 
        for(int t = 0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine()); 
        	int[][] arr = new int[2][N]; 
        	for(int i = 0; i < 2; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken()); 
        		}
        	}
        	bw.write(solution(arr, N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();     
	}
	
	static int solution(int[][] arr, int N) {
		int[][] dp = new int[2][N]; 
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < 2; i++) {
				int ni = Math.abs(i - 1);
				if(j == 0) {
					dp[i][j] = arr[i][j]; 
				} 
				else if(j == 1) {
					dp[i][j] = arr[i][j] + dp[ni][j - 1]; 
				} else {
					dp[i][j] = Math.max(dp[ni][j - 1], dp[ni][j - 2]) + arr[i][j]; 					
				}
			}
		}
		return Math.max(dp[0][N - 1], dp[1][N - 1]); 
	}
}
