import java.io.*;
import java.util.*;

public class Main {
    static int N, M, emptyCnt, min; 
    static int[][] board; 
    static ArrayList<Virus> viruses; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        board = new int[N][N]; 
        viruses = new ArrayList<>(); 
        min = Integer.MAX_VALUE; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken()); 
                if(input == 0) emptyCnt++; 
                else if (input == 2) viruses.add(new Virus(i, j)); 
                board[i][j] = input; 
            }
        }
        if(emptyCnt == 0) bw.write("0"); 
        else {
            activeVirus(0, 0, new int[M], viruses.size()); 
            if(min == Integer.MAX_VALUE) bw.write("-1"); 
            else bw.write(min + ""); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void activeVirus(int cnt, int idx, int[] active, int size) {
        if(cnt == M) {
            bfs(active); 
            return; 
        }
        for(int i = idx; i < size; i++) {
            active[cnt] = i; 
            activeVirus(cnt + 1, i + 1, active, size); 
        }
    }

    private static void bfs(int[] active) {
        int infectedCount = 0; 
        boolean[][] visit = new boolean[N][N]; 
        Queue<Virus> q = new ArrayDeque<>(); 
        int time = 0; 

        for(int idx: active) {
            Virus activeVirus = viruses.get(idx); 
            q.offer(activeVirus); 
            visit[activeVirus.x][activeVirus.y] = true; 
        }

        while(!q.isEmpty()) {
            if(infectedCount == emptyCnt) {
                min = Math.min(time, min); 
                return; 
            }
            int size = q.size(); 
            for(int i = 0; i < size; i++) {
                Virus tmp = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = tmp.x + dirx[d]; 
                    int ny = tmp.y + diry[d]; 
    
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || board[nx][ny] == 1) continue; 
                    if(board[nx][ny] == 0) infectedCount++;
                    visit[nx][ny] = true; 
                    q.offer(new Virus(nx, ny)); 
                }
            }
            time++; 
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