
import java.io.*; 
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int[] dp = new int[n]; 
		for(int i = 0; i < n; i++) {
			dp[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int max = dp[0]; 
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
			max = Math.max(dp[i], max); 
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
	}	
}
