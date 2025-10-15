class Solution {
    int max = 0; 
    int[][] dungeons; 
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.dungeons = dungeons; 
        dfs(0, new boolean[dungeons.length], 0, k); 
        
        return max;
    }
    
    public void dfs(int depth, boolean[] visited, int cnt, int stamina) {
         max = Math.max(max, cnt); 
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > stamina) continue; 
            visited[i] = true; 
            dfs(depth + 1, visited, cnt + 1, stamina - dungeons[i][1]); 
            visited[i] = false;
        }
    }
}