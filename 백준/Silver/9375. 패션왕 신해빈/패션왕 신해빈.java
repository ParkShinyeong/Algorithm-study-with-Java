import java.io.*;
import java.util.*;

public class Main {
	static int N; 
	static Map<String, Integer> map; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); 
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); 
			map = new HashMap<String, Integer>(); 
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); 
				String cloth = st.nextToken(); 
				String sort = st.nextToken(); 
				map.put(sort, map.getOrDefault(sort, 0) + 1); 
			}
			bw.write(solution() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int solution() {
		int result = 1; 
		for(int val : map.values()) {
			result *= (val + 1); 
		}
		result -= 1;
		return result; 
	}
}
