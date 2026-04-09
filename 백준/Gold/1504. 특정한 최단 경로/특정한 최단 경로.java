import java.io.*;
import java.util.*;

public class Main {
    static int N, E; 
    static int maxValue = Integer.MAX_VALUE; 
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        E = Integer.parseInt(st.nextToken()); 
        graph = new ArrayList[N + 1]; 
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            int cost = Integer.parseInt(st.nextToken()); 
            graph[n1].add(new Edge(n2, cost)); 
            graph[n2].add(new Edge(n1, cost)); 
        } 
        
        st = new StringTokenizer(br.readLine()); 
        int n1 = Integer.parseInt(st.nextToken()); 
        int n2 = Integer.parseInt(st.nextToken()); 


        bw.write(solution(n1, n2) + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution(int n1, int n2) {
        int[] startLen = dijkstra(n1);
        int[] endLen = dijkstra(n2); 
        int len = startLen[n2]; 

        if(startLen[1] == maxValue || endLen[1] == maxValue 
            || startLen[N] == maxValue || endLen[N] == maxValue || len == maxValue) return -1; 
    
        int dist1 = startLen[1] + endLen[N]; 
        int dist2 = startLen[N] + endLen[1]; 
        return len + Math.min(dist1, dist2); 
    }

    private static int[] dijkstra(int start) {
        int[] len = new int[N + 1]; 
        Arrays.fill(len, maxValue); 
        len[start] = 0; 
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        pq.offer(new Edge(start, 0)); 

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll(); 
            if(len[tmp.node] < tmp.cost) continue; 

            for(Edge nxt: graph[tmp.node]) {
                int cost = tmp.cost + nxt.cost; 
                if(len[nxt.node] <= cost) continue; 
                len[nxt.node] = cost; 
                pq.offer(new Edge(nxt.node, cost)); 
            }
        }

        return len; 
    }


}

class Edge {
    int node, cost; 
    Edge(int node, int cost) {
        this.node = node; 
        this.cost = cost; 
    }
}