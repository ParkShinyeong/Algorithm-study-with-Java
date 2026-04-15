import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[] dirx = {0, -1, -1, -1, 0, 1, 1, 1}; 
    static int[] diry = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] diagonalx = {1, 1, -1, -1}; 
    static int[] diagonaly = {-1, 1, -1, 1}; 
    static int[][] board; 
    static int[][] move; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        board = new int[N][N]; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        move = new int[M][2]; 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            move[i][0] = Integer.parseInt(st.nextToken()) - 1; // 방향 d
            move[i][1] = Integer.parseInt(st.nextToken()); // 이동칸 수 s
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        Queue<Position> clouds = setCloud(); 
        
        for(int t = 0; t < M; t++) {
            int d = move[t][0]; 
            int s = move[t][1]; 
            
            boolean[][] isClouds = new boolean[N][N]; 
            moveCloud(clouds, isClouds, d, s);  // 1, 2, 3번 
            
            copyWaterBug(isClouds); // 물 복사 버그 마법
            clouds = createClouds(isClouds); 
        }

        return getTotalWater(); 
    }
    
    private static Queue<Position> setCloud() {
        Queue<Position> clouds = new ArrayDeque<>(); 
        clouds.offer(new Position(N - 1, 0)); 
        clouds.offer(new Position(N - 1, 1)); 
        clouds.offer(new Position(N - 2, 0)); 
        clouds.offer(new Position(N - 2, 1)); 
        return clouds; 
    }

    private static void moveCloud(Queue<Position> clouds, boolean[][] isClouds, int d, int s) {
        while(!clouds.isEmpty()) {
            Position tmp = clouds.poll(); 
            int nx = (tmp.x + (dirx[d] + N) * s) % N; 
            int ny = (tmp.y + (diry[d] + N) * s) % N; 
            
            isClouds[nx][ny] = true; 
            board[nx][ny]++; // 각 구름에서 비가 내림 
        }
    }

    private static void copyWaterBug(boolean[][] isClouds) {
        int[][] cnts = new int[N][N]; 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isClouds[i][j]) continue; 
                int cnt = 0; 
                for(int d = 0; d < diagonalx.length; d++) {
                    int nx = i + diagonalx[d]; 
                    int ny = j + diagonaly[d]; 

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 0) continue;
                    cnt++;  
                }
                cnts[i][j] += cnt; 
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] += cnts[i][j]; 
            }
        }
    }

    private static Queue<Position> createClouds(boolean[][] isClouds) {
        Queue<Position> newClouds = new ArrayDeque<>(); 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] < 2 || isClouds[i][j]) continue; 
                newClouds.offer(new Position(i, j)); 
                board[i][j] -= 2; 
            }
        }
        return newClouds; 
    }

    private static int getTotalWater() {
        int total = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                total += board[i][j];  
            }
        }
        return total; 
    }
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}