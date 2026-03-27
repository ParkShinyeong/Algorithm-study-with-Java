import java.io.*;
import java.util.*;

public class Main {
    static int V, E; 
    static ArrayList<Edge>[] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        V = Integer.parseInt(st.nextToken());  
        E = Integer.parseInt(st.nextToken());  
        graph = new ArrayList[V + 1]; 
        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v1].add(new Edge(v2, w));
            graph[v2].add(new Edge(v1, w)); 
        }
        bw.write(prim() + ""); 
        bw.flush();    
        bw.close(); 
        br.close(); 
    }

    private static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
        
        
        int start = 1; 
        boolean[] visit = new boolean[V + 1]; 
        visit[start] = true;
        for(Edge nxt: graph[start]) {
            pq.offer(nxt); // 끝 정점, 가중치 순
        }
        
        int edgeCnt = 0; 
        int total = 0; 
        
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll(); 
            
            if(visit[tmp.target]) continue; 
            total += tmp.cost; 
            edgeCnt++; 

            if(edgeCnt == V - 1) break; 

            visit[tmp.target] = true; 
            for(Edge nxt: graph[tmp.target]) {
                pq.offer(nxt);
            }
        }
        return total; 
    }
}

class Edge implements Comparable<Edge> {
    int target, cost; 
    Edge (int target, int cost) {
        this.target = target; 
        this.cost = cost; 
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost; 
    }   
}