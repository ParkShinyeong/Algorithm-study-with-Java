import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int from;
	int to ;
	int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight); 
	}
}

public class Main {
	static Edge[] edgeList; 
	static int[] parents; 
	static int V, E; 
	static void make() {
		parents = new int[V + 1]; 
		for(int i = 1; i <= V; i++) {
			parents[i] = i; 
		}
	}
	
	static int find(int a) { 
		if(a == parents[a]) return a; 
		return parents[a] = find(parents[a]); 
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a); 
		int rootB = find(b); 
		
		if(rootA == rootB) return false; 
		parents[rootA] = rootB; 
		return true; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken()); 
		edgeList = new Edge[E]; 
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight); 
		}
		
		make(); 
		Arrays.sort(edgeList);
		
		int result = 0; 
		for(Edge edge: edgeList) {
			if(union(edge.from, edge.to)) { 
				result += edge.weight; 
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
