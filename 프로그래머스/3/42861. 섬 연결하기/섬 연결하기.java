import java.util.*; 

class Solution {
    int[] parents; 
    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> edges = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        
        for(int i = 0; i < costs.length; i++) {
            int v1 = costs[i][0]; 
            int v2 = costs[i][1]; 
            int cost = costs[i][2]; 
            edges.add(new Edge(v1, v2, cost)); 
        }
        
        parents = new int[n]; 
        Arrays.fill(parents, -1); 
        
        int edgeCnt = 0; 
        int cost = 0; 
        
        while(!edges.isEmpty()) {
            Edge tmp = edges.poll(); 
            if(!union(tmp.v1, tmp.v2)) continue; 
            edgeCnt++; 
            cost += tmp.cost; 
            if(edgeCnt == n - 1) break; 
        }
        
        return cost;
    }
    
    private boolean union(int v1, int v2) {
        int p1 = find(v1); 
        int p2 = find(v2); 
        if(p1 != p2) {
            parents[p1] = find(p2); 
            return true; 
        }
        return false; 
    }
    
    private int find(int v) {
        if(parents[v] < 0) return v;  
        return parents[v] = find(parents[v]); 
    }
}

class Edge {
    int cost, v1, v2; 
    Edge(int v1, int v2, int cost) {
        this.cost = cost; 
        this.v1 = v1; 
        this.v2 = v2; 
    }
}