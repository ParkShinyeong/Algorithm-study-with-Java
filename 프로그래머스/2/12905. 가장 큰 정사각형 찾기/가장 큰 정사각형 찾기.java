import java.util.*; 

class Solution {
    int[] dirx = {-1, 0, -1}; 
    int[] diry = {-1, -1, 0}; 
    
    public int solution(int [][]board) {
        int w = board.length; 
        int h = board[0].length; 
        int[][] dp = new int[w][h]; 
        int max = 0; 
        
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(board[i][j] == 0) continue; 
                int min = Integer.MAX_VALUE; 
                
                for(int d = 0; d < 3; d++) {
                    int nx = i + dirx[d]; 
                    int ny = j + diry[d]; 
                    if(nx < 0 || ny < 0) {
                        min = 0; 
                        continue; 
                    }
                    min = Math.min(min, dp[nx][ny]); 
                }
                
                dp[i][j] = min + 1; 
                max = Math.max(max, dp[i][j]); 
            }
        }
        
        return max * max;
        
    }  
}