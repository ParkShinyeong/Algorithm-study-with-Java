import java.util.*; 
class Solution {
    static int N; 
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n; 
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; 
        ArrayList<Integer>[] reverseGraph = new ArrayList[n + 1]; 
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>(); 
            reverseGraph[i] = new ArrayList<>(); 
        }
        
        for(int i = 0; i < results.length; i++) {
            int winner = results[i][0]; 
            int loser = results[i][1]; 
            
            graph[winner].add(loser); 
            reverseGraph[loser].add(winner); 
        }
        
        for(int i = 1; i <= n; i++) {
            int cnt = getCnt(i, graph) + getCnt(i, reverseGraph); 
            if(cnt == n - 1) answer++; 
        }
        
        return answer;
    }
    
    private int getCnt(int node, ArrayList<Integer>[] graph) {
        int cnt = 0; 
        boolean[] visit = new boolean[N + 1]; 
        Queue<Integer> q = new ArrayDeque<>(); 
        q.offer(node); 
        visit[node] = true; 
        while(!q.isEmpty()) {
            int tmp = q.poll(); 
            for(int nxt: graph[tmp]) {
                if(visit[nxt]) continue; 
                visit[nxt] = true; 
                q.offer(nxt); 
                cnt++; 
            }
        }
        return cnt; 
    }
}