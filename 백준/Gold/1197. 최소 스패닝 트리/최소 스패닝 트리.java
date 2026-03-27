import java.io.*;
import java.util.*;

public class Main {
    static int V, E; 
    static ArrayList<int[]>[] graph; 
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

            graph[v1].add(new int[] {v2, w});
            graph[v2].add(new int[] {v1, w}); 
        }
        bw.write(prim() + ""); 
        bw.flush();    
        bw.close(); 
        br.close(); 
    }

    private static int prim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2]; 
        }); 
        
        
        int start = 1; 
        boolean[] visit = new boolean[V + 1]; 
        visit[start] = true;
        for(int[] nxt: graph[start]) {
            pq.offer(new int[] {start, nxt[0], nxt[1]}); // 시작 정점, 끝 정점, 가중치 순
        }
        
        int edgeCnt = 0; 
        int total = 0; 
        
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll(); 
            if(edgeCnt == V - 1) break; 

            if(visit[tmp[1]]) continue; 
            total += tmp[2]; 
            edgeCnt++; 
            visit[tmp[1]] = true; 
            for(int[] nxt: graph[tmp[1]]) {
                pq.offer(new int[] {tmp[1], nxt[0], nxt[1]});
            }
        }
        return total; 
    }
}