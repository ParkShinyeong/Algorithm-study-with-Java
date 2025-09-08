import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine()); 
		ArrayList<Integer>[] matrix = new ArrayList[N + 1]; 
		for(int i = 1; i <= N; i++) {
			matrix[i] = new ArrayList<>(); 
		}
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()); 
			int n2 = Integer.parseInt(st.nextToken()); 
			matrix[n1].add(n2); 
			matrix[n2].add(n1); 			
		}
		Queue<int[]> queue = new ArrayDeque<int[]>(); 
		boolean[] visited = new boolean[N + 1]; 
		queue.offer(new int[] {1, 0}); 
		visited[1] = true; 
		int ans = 0; 
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll(); 
			ans++; 
			for(int friend : matrix[tmp[0]]) {
				if(!visited[friend] && tmp[1] < 2) {
					queue.offer(new int[] {friend, tmp[1] + 1}); 
					visited[friend] = true; 
				}
			}
		}
		bw.write(ans - 1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
