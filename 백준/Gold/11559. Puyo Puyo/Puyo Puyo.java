import java.io.*;
import java.util.*;

public class Main {
    static char[][] board; 
    static boolean[][] isVisited; 
    static int[] dirx = {0, -1, 0, 1}; 
    static int[] diry = {1, 0, -1, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        board = new char[12][6]; 
        isVisited = new boolean[12][6]; 

        for(int i = 0; i < 12; i++) {
            String input = br.readLine(); 
            for(int j = 0; j < 6; j++) {
                board[i][j] = input.charAt(j); 
            }
        }

        int cnt = 0; 
        while(true) {
            boolean isPuyo = false; 
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(board[i][j] != '.' && !isVisited[i][j]) {
                        List<int[]> puyo = bfs(i, j); 
                        if(puyo.size() < 4) continue; 
                        isPuyo = true; 
                        for(int[] pos: puyo) {
                            board[pos[0]][pos[1]] = 'X'; 
                        }
                    }
                }
            }
            if(!isPuyo) break; 
            cnt++;  
            board = puyo(); 
            isVisited = new boolean[12][6]; 
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static char[][] puyo () {
        char[][] puyoBoard = new char[12][6]; 

        for(int j = 0; j < 6; j++) {
            Queue<Character> q = new ArrayDeque<>(); 
            for(int i = 11; i >= 0; i--) {
                if(board[i][j] != 'X') q.offer(board[i][j]); 
            }

            for(int i = 11; i >= 0; i--) {
                if(q.isEmpty()) {
                    puyoBoard[i][j] = '.'; 
                    continue; 
                } 
                char c = q.poll(); 
                puyoBoard[i][j] = c; 
            }
        }

        return puyoBoard; 
    }

    static List<int[]> bfs(int x, int y) {
        char tmp = board[x][y]; 
        isVisited[x][y] = true; 

        Queue<int[]> queue = new ArrayDeque<>(); 
        queue.offer(new int[] {x, y}); 

        List<int[]> puyo = new ArrayList<>(); 
        puyo.add(new int[]{x, y}); 

        while(!queue.isEmpty()) {
            int[] tmpPos = queue.poll(); 
            int tx = tmpPos[0]; 
            int ty = tmpPos[1]; 
            for(int d = 0; d < 4; d++) {
                int nx = tx + dirx[d]; 
                int ny = ty + diry[d]; 

                if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || board[nx][ny] != tmp || isVisited[nx][ny]) continue; 
                queue.offer(new int[] {nx, ny}); 
                isVisited[nx][ny] = true; 
                puyo.add(new int[] {nx, ny}); 
            }
        }
        return puyo; 
    }
}