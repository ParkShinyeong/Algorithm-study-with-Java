import java.io.*;
import java.util.*; 

public class Main {
	static long[] memo; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken()); 
        
        long ans = getMultiply(A, B, C); 
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static long getMultiply(int A, int B, int C) {
		if(B == 0) return 1;
		
		long temp = getMultiply(A, B / 2, C) % C;
		if(B % 2 == 1) {
			return ((temp * temp) % C * (A % C)) % C; 
		}
		return (temp * temp) % C; 
	}
}
