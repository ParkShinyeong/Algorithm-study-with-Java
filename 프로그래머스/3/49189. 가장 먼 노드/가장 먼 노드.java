import java.util.*; 
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>(); 
        }
        for(int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0]; 
            int v2 = edge[i][1]; 
            graph[v1].add(v2);
            graph[v2].add(v1); 
        }
        
        int start = 1; 
        int[] length = new int[n + 1]; 
        Arrays.fill(length, -1);
        length[start] = 0; 
        Queue<Integer> queue = new ArrayDeque<>(); 
        queue.offer(start);  // 노드, 가중치 
        
        int max = 0; 
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll(); 
            
            for(int nxt: graph[tmp]) {
                if(length[nxt] >= 0) continue; 
                length[nxt] = length[tmp] + 1; 
                queue.offer(nxt); 
                max = Math.max(length[nxt], max); 
            }
        }
        
        int answer = 0; 
        for(int i = 1; i <= n; i++) {
            if(length[i] == max) answer++; 
        }
        return answer; 
    }
}