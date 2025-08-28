import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		bw.write(solution(n, k));
		bw.flush(); 
		bw.close();
		br.close();
	}
	public static String solution(int n, int k) {
		Queue<Integer> dq = new ArrayDeque<>(); 
		List<Integer> ans = new ArrayList<>(); 
		for(int i = 1; i <= n; i++) {
			dq.add(i); 
		}
		int cnt = 1; 
		while(!dq.isEmpty()) {
			int tmp = dq.poll(); 
			if(cnt % k == 0) {
				ans.add(tmp); 
			} else {
				dq.add(tmp); 				
			}
			cnt++; 
		}
		return ans.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", ", "<", ">")); 
	}
}
