
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        Map<String, String> user = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine()); 
        	String site = st.nextToken(); 
        	String pw = st.nextToken(); 
        	user.put(site, pw);
        }
        
        for(int i = 0; i < M; i++) {
        	String input = br.readLine(); 
        	bw.write(user.get(input) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
	}
}
