import java.io.*;
import java.util.*;
public class Main {
	static int INF = Integer.MAX_VALUE; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int V = Integer.parseInt(st.nextToken());  
		int E = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(br.readLine()); 
		ArrayList<int[]>[] graph = new ArrayList[V + 1]; 
		for(int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<int[]>(); 
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new int[] { v, w }); 
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[1], b[1]); 
		}); 
		int[] distance = new int[V + 1]; 
		for(int i = 0; i <= V; i++) {
			distance[i] = INF; 
		}
		distance[K] = 0; 
		pq.offer(new int[] { K, 0 }); 
		while(!pq.isEmpty()) {
			int[] current = pq.poll(); 
			int currentVertex = current[0]; 
			int currentDistance = current[1]; 
			if(currentDistance > distance[currentVertex]) continue; 
			for(int[] edge : graph[currentVertex]) {
				int nextVertex = edge[0]; 
				int weight = edge[1]; 
				
				if(distance[nextVertex] > currentDistance + weight) { // 현재 값이 원래 값보다 더 작다면
					distance[nextVertex] = currentDistance + weight; // 값 갱신
					pq.offer(new int[] {nextVertex, distance[nextVertex]}); // pq에 값 넣어준다. 
				}
			}
		}
		for(int i = 1; i <= V; i++) {
			String answer = distance[i] == INF ? "INF\n" : distance[i] + "\n"; 
			bw.write(answer);
		}
		bw.flush(); 
		bw.close(); 
		br.close(); 
	}
}
