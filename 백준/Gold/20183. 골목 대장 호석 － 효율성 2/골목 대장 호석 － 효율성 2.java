import java.io.*;
import java.util.*;

public class Main {
    static int N, M, A, B, minCost, maxCost; 
    static long C; 
    static ArrayList<Edge>[] graph; 
    static long INF = Long.MAX_VALUE; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        A = Integer.parseInt(st.nextToken()); 
        B = Integer.parseInt(st.nextToken()); 
        C = Long.parseLong(st.nextToken()); 
        graph = new ArrayList[N + 1]; 

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        minCost = Integer.MAX_VALUE; 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken()); 
            int end = Integer.parseInt(st.nextToken()); 
            int cost = Integer.parseInt(st.nextToken()); 
            graph[start].add(new Edge(end, cost)); 
            graph[end].add(new Edge(start, cost)); 
            minCost = Math.min(minCost, cost); 
            maxCost = Math.max(maxCost, cost); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    private static int solution() {
        int lt = minCost, rt = maxCost; 
        boolean flag = false; 
        while(lt <= rt) {
            int mid = (lt + rt) / 2; 
            long result = dijkstra(mid); 
            if(result <= C) { 
                rt = mid - 1; 
                flag = true; 
            } else {
                lt = mid + 1; 
            }
        }

        return flag ? lt : -1; 
    }
    private static long dijkstra(int upper) {
        long[] costs = new long[N + 1]; 
        Arrays.fill(costs, INF); 
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.cost, b.cost); 
        }); 
        pq.offer(new Edge(A, 0)); 
        costs[A] = 0; 

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();  
            if(costs[tmp.node] < tmp.cost) continue; 

            for(Edge nxt: graph[tmp.node]) {
                if(nxt.cost > upper) continue; 

                long cost = nxt.cost + tmp.cost; 
                if(costs[nxt.node] <= cost) continue; 
                costs[nxt.node] = cost; 
                pq.offer(new Edge(nxt.node, cost)); 
            }
        }
        return costs[B]; 
    }
}

class Edge {
    int node;
    long cost; 
    Edge (int node, long cost) {
        this.node = node; 
        this.cost = cost; 
    }
}