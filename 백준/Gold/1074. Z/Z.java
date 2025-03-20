import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int r = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 
    	int len = (int)Math.pow(2, N); 
        int answer = solution(r, c, len); 
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int solution(int r, int c, int len) {
    	if(len == 1) return 0; 
    	
    	int pos = 0; 
    	int mid = len / 2; 
    	if(r < mid && c < mid) pos = 1; 
    	else if(r < mid && c >= mid) {
    		pos = 2; 
    		c -= mid; 
    	}
    	else if(r >= mid && c < mid) {
    		pos = 3; 
    		r -= mid; 
    	}
    	else {
    		c -= mid; 
    		r -= mid; 
    		pos = 4; 
    	}
    	return (int)(Math.pow(mid, 2) * (pos - 1)) + solution(r, c, mid); 
    }
}
