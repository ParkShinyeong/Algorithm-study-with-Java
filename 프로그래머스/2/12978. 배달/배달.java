import java.util.*; 
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<Edge>[] graph = new ArrayList[N + 1]; 
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }
        
        for(int i = 0; i < road.length; i++) {
            int n1 = road[i][0]; 
            int n2 = road[i][1]; 
            int cost = road[i][2]; 
            graph[n1].add(new Edge(n2, cost)); 
            graph[n2].add(new Edge(n1, cost)); 
        }
        
        int[] lengths = new int[N + 1]; 
        Arrays.fill(lengths, Integer.MAX_VALUE); 
        
        int start = 1;
        lengths[start] = 0; 
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        pq.offer(new Edge(start, 0)); 
        
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll(); 
            if(tmp.cost > lengths[tmp.node]) continue; 
            
            for(Edge nxt: graph[tmp.node]) {
                int nxtCost = nxt.cost + tmp.cost; 
                if(nxtCost >= lengths[nxt.node]) continue; 
                pq.offer(new Edge(nxt.node, nxtCost)); 
                lengths[nxt.node] = nxtCost; 
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(lengths[i] <= K) answer++; 
        }
        
        return answer;
    }
}

class Edge {
    int node, cost; 
    Edge(int n, int c) {
        this.node = n; 
        this.cost = c; 
    }
}