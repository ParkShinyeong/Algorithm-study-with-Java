import java.io.*;
import java.util.*;

public class Main {
    static final int N = 5; 
    static int[] dirz = new int[] {-1, 1, 0, 0, 0, 0}; 
    static int[] dirx = new int[] {0, 0, -1, 1, 0, 0}; 
    static int[] diry = new int[] {0, 0, 0, 0, -1, 1}; 
    static int[][][] maze; 
    static int min = Integer.MAX_VALUE; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st; 
        
        maze = new int[N][N][N]; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine()); 
                for(int k = 0; k < N; k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken()); 
                }
            }
        }

        rotateBoard(0); 
        if(min == Integer.MAX_VALUE) min = -1; 
        bw.write(String.valueOf(min)); 

   
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void stackBoard(int count, int[][][] stackMaze, boolean[] isVisit) {
        if(count == 5) {
            if(stackMaze[0][0][0] == 0 || stackMaze[N - 1][N - 1][N - 1] == 0) return;  
            int cnt = findExit(stackMaze); 
            if(cnt >= 0) {
                if(min != -1) min = Math.min(cnt, min); 
                else min = cnt; 
            } 
            return; 
        }

        for(int i = 0; i < 5; i++) {
            if(isVisit[i]) continue; 
            isVisit[i] = true; 
            stackMaze[count] = maze[i]; 
            stackBoard(count + 1, stackMaze, isVisit);
            isVisit[i] = false; 
        }
    }

    static void rotateBoard(int idx) { 
        if(idx == 5) {
            stackBoard(0, new int[N][N][N], new boolean[N]);
            return; 
        }

        for(int i = 0; i < 4; i++) {
            rotateClockWise(idx); 
            rotateBoard(idx + 1); 
        }
    }

    static void rotateClockWise(int idx) {
        int[][] board = maze[idx]; 
        int[][] rotateBoard = new int[N][N]; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                rotateBoard[j][N - 1 - i] = board[i][j]; 
            }
        }
        maze[idx] = rotateBoard;  
    }

    static int findExit(int[][][] maze) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(0, 0, 0, 0));  
        boolean[][][] isVisited = new boolean[N][N][N];
        isVisited[0][0][0] = true; 
        
        while(!queue.isEmpty()) {
            Position tmp = queue.poll(); 

            if(tmp.x == N - 1 && tmp.y == N - 1 && tmp.z == N - 1) {
                return tmp.movingCnt; 
            }

            for(int d = 0; d < 6; d++) {
                int nx = tmp.x + dirx[d]; 
                int ny = tmp.y + diry[d]; 
                int nz = tmp.z + dirz[d]; 
                
                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= N || nz >= N 
                    || isVisited[nx][ny][nz] || maze[nx][ny][nz] == 0) continue; 
                
                isVisited[nx][ny][nz] = true; 
                queue.offer(new Position(nx, ny, nz, tmp.movingCnt + 1)); 
            }
        }

        return -1; 
    }
}

class Position {
    int x, y, z;
    int movingCnt; 
    Position(int x, int y, int z, int movingCnt) {
        this.x = x; 
        this.y = y; 
        this.z = z; 
        this.movingCnt = movingCnt; 
    }
}