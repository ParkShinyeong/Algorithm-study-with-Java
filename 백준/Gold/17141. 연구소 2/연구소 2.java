import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int emptyCnt = 0; 
    static int[][] board; 
    static ArrayList<Virus> viruses; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    static int minCnt = Integer.MAX_VALUE; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        board = new int[N][N]; 
        viruses = new ArrayList<>(); 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken()); 
                board[i][j] = input; 
                if(input != 1) emptyCnt++; 
                if(input == 2) viruses.add(new Virus(i, j)); 
            }
        }
        emptyCnt -= M; 

        dfs(0, 0, new int[M], viruses.size()); 

        if(emptyCnt <= 0) {
            bw.write("0"); 
        } else {
            if(minCnt == Integer.MAX_VALUE) bw.write("-1"); 
            else bw.write(minCnt + ""); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int cnt, int idx, int[] active, int size) {
        if(cnt == M) {
            bfs(active); 
            return; 
        }

        for(int i = idx; i < size; i++) {
            active[cnt] = i; 
            dfs(cnt + 1, i + 1, active, size); 
        }
    }

    private static void bfs(int[] active) {
        int infectionCnt = 0; 
        Queue<Virus> queue = new ArrayDeque<>(); 
        boolean[][] visit = new boolean[N][N]; 
        for(int idx : active) {
            Virus tmp = viruses.get(idx); 
            queue.offer(tmp); 
            visit[tmp.x][tmp.y] = true; 
        }

        int time = 0;

        while(!queue.isEmpty()) {
            int size = queue.size(); 
            

            for(int i = 0; i < size; i++) {
                Virus tmp = queue.poll(); 
                for(int d = 0; d < 4; d++) {
                    int nx = tmp.x + dirx[d]; 
                    int ny = tmp.y + diry[d]; 

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || board[nx][ny] == 1) continue; 
                    visit[nx][ny] = true; 
                    queue.offer(new Virus(nx, ny)); 
                    infectionCnt++; 
                }   
            }
            time++; 
        }

        if(infectionCnt == emptyCnt) {
            minCnt = Math.min(time - 1, minCnt);
        }
    }
}

class Virus {
    int x, y; 
    Virus(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}