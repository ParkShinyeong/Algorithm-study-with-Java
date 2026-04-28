import java.util.*; 

class Solution {
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] board = new int[101][101]; 
        for(int i = 0; i < rectangle.length; i++) {
            int sx = rectangle[i][0]; 
            int sy = rectangle[i][1]; 
            int ex = rectangle[i][2]; 
            int ey = rectangle[i][3]; 
            for(int x = sx * 2; x <= ex * 2; x++) {
                for(int y = sy * 2; y <= ey * 2; y++) {
                    if(board[x][y] == 0) board[x][y] = 1; 
                }
            }
            for(int x = sx * 2 + 1; x < ex * 2; x++) {
                for(int y = sy * 2 + 1; y < ey * 2; y++) {
                    board[x][y] = 2; 
                }
            }
        }
        
        int cx = characterX * 2;
        int cy = characterY * 2; 
        int ix = itemX * 2; 
        int iy = itemY * 2; 
        
        Queue<int[]> queue = new ArrayDeque<>(); 
        queue.offer(new int[] {cx, cy, 0}); // x, y, 거리 
        boolean[][] isVisit = new boolean[101][101]; 
        isVisit[cx][cy] = true; 
        
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll(); 
            int tmpx = tmp[0]; 
            int tmpy = tmp[1]; 
            int tmplen = tmp[2]; 
            
            if(tmpx == ix && tmpy == iy) {
                answer = tmplen / 2; 
                break; 
            }
            
            for(int d = 0; d < 4; d++) {
                int nx = tmpx + dirx[d]; 
                int ny = tmpy + diry[d]; 
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100 || 
                   board[nx][ny] != 1 || isVisit[nx][ny]) continue; 
                
                isVisit[nx][ny] = true; 
                queue.offer(new int[]{nx, ny, tmplen + 1}); 
            }
        }
        return answer;
    }

}