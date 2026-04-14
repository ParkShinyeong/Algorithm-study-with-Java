import java.io.*;
import java.util.*;

public class Main {
    static int N, M, G, R; 
    static int max; 
    static int[][] board; 
    static ArrayList<Position> landWithLiquid; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        G = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken()); 

        board = new int[N][M]; 
        landWithLiquid = new ArrayList<>(); 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
                if(board[i][j] == 2) landWithLiquid.add(new Position(i, j)); 
            }
        }
        setGreen(new boolean[landWithLiquid.size()], 0, 0, new int[G]); 
        bw.write(max + ""); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void setGreen(boolean[] visit, int idx, int cnt, int[] green) {
        if(cnt == G) {
            setRed(visit, 0, 0, new int[R], green); 
            return; 
        }

        for(int i = idx; i < landWithLiquid.size(); i++) {
            visit[i] = true; 
            green[cnt] = i; 
            setGreen(visit, i + 1, cnt + 1, green); 
            visit[i] = false; 
        }
    }

    private static void setRed(boolean[] visit, int idx, int cnt, int[] red, int[] green) {
        if(cnt == R) {
            max = Math.max(getFlower(green, red), max); 
            return; 
        }

        for(int i = idx; i < landWithLiquid.size(); i++) {
            if(visit[i]) continue; 
            visit[i] = true; 
            red[cnt] = i; 
            setRed(visit, i + 1, cnt + 1, red, green); 
            visit[i] = false; 
        }
    }

    private static int getFlower(int[] green, int[] red) {
        int[][] land = new int[N][M]; 
        int[][] time = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(time[i], -1); 
        } 

        int tmpTime = 0; 
        Queue<Position> queue = new ArrayDeque<>(); 
        for(int i : green) {
            Position pos = landWithLiquid.get(i); 
            land[pos.x][pos.y] = 1;  // Green
            time[pos.x][pos.y] = tmpTime; // 시간 
            queue.offer(pos); 
        }
        for(int i : red) {
            Position pos = landWithLiquid.get(i); 
            land[pos.x][pos.y] = -1;  // Green
            time[pos.x][pos.y] = tmpTime; // 시간 
            queue.offer(pos);
        }

        while(!queue.isEmpty()) {
            tmpTime++; 
            int size = queue.size(); 
            for(int i = 0; i < size; i++) {
                Position pos = queue.poll(); 
                int tmpColor = land[pos.x][pos.y]; 
                if(land[pos.x][pos.y] == 2) continue; 

                for(int d = 0; d < 4; d++) {
                    int nx = pos.x + dirx[d]; 
                    int ny = pos.y + diry[d]; 
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 0 || land[nx][ny] == 2) continue; 
                    if(land[nx][ny] + tmpColor == 0 && time[nx][ny] == tmpTime){
                        land[nx][ny] = 2; 
                        continue; 
                    }
                    if(land[nx][ny] != 0) continue; 
                    land[nx][ny] = tmpColor; 
                    time[nx][ny] = tmpTime; 
                    queue.offer(new Position(nx, ny)); 
                }
            }
        }

        int flower = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 2) flower++; 
            }
        }
        return flower;
    }
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}