import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> check = new TreeMap<>(); 
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); 
				
				char calc = st.nextToken().charAt(0); 
				int num = Integer.parseInt(st.nextToken()); 
				
				if(calc == 'I') {
					check.put(num, check.getOrDefault(num, 0) + 1); 
				} else if(calc == 'D' && num == 1) {
					// Q에서 최댓값 삭제 
					if(check.size() == 0) continue; 
					int max = check.lastKey(); 
					check.put(max, check.get(max) - 1); 
					if(check.get(max) == 0) check.remove(max); 
				} else if(calc == 'D' && num == -1) {
					if(check.size() == 0) continue; 
					int min = check.firstKey(); 
					check.put(min, check.get(min) - 1); 
					if(check.get(min) == 0) check.remove(min); 
				}
			}
			
			if(check.size() == 0) {
				bw.write("EMPTY");
			} else {
				int max = check.lastKey(); 
				int min = check.firstKey(); 
				bw.write(max + " " + min);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
