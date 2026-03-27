import java.io.*;
import java.util.*;

public class Main {
    static int V, E; 
    static PriorityQueue<Edge> edges; 
    static int[] parents; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        V = Integer.parseInt(st.nextToken());  
        E = Integer.parseInt(st.nextToken());  
        edges = new PriorityQueue<>(); 
        parents = new int[V + 1]; 
        Arrays.fill(parents, -1); 

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.offer(new Edge(v1, v2, w)); 
        }
        bw.write(kruskal() + ""); 
        bw.flush();    
        bw.close(); 
        br.close(); 
    }

    private static int kruskal() {
        int totalCost = 0; 
        while(!edges.isEmpty()) {
            Edge edge = edges.poll(); 
            if(union(edge.v1, edge.v2)) {
                totalCost += edge.cost; 
            }
        }
        return totalCost; 
    }

    private static boolean union(int v1, int v2) {
        int p1 = find(v1); 
        int p2 = find(v2); 
        if(p1 != p2) {
            parents[p2] = p1;
            return true; 
        }
        return false; // 이미 같은 집합임 
    }

    private static int find(int v) {
        if(parents[v] < 0) return v; 
        return parents[v] = find(parents[v]); 
    }
}

class Edge implements Comparable<Edge> {
    int v1, v2, cost; 
    Edge (int v1, int v2, int cost) {
        this.v1 = v1; 
        this.v2 = v2; 
        this.cost = cost; 
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost; 
    }   
}