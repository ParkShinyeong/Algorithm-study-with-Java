import java.io.*;
import java.util.*; 

public class Main {
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    static int maxSize = 0; 
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        int[][] board = new int[n][m]; 

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int cnt = 0; 

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(board[i][j] == 1) {
                    solution(n, m, board, i, j); 
                    cnt++; 
                }
            }
        }
        bw.write(cnt + "\n"); 
        bw.write(maxSize +""); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution(int n, int m, int[][] board, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>(); 
        board[x][y]--; 
        queue.offer(new int[] {x, y}); 
        int size = 0; 

        while(!queue.isEmpty()) {
            int[] pos = queue.poll(); 
            int tmpx = pos[0]; 
            int tmpy = pos[1];
            size++; 
            
            for(int d = 0; d < 4; d++) {
                int nx = tmpx + dirx[d]; 
                int ny = tmpy + diry[d]; 
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] != 1) continue;
                board[nx][ny]--; 
                queue.offer(new int[]{nx, ny}); 
            }
        }
        maxSize = Math.max(maxSize, size); 
    }
}
