import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[][] board; 
    static ArrayList<int[]> virusPosition; 
    static int answer = Integer.MIN_VALUE; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        board = new int[N][M]; 
        virusPosition = new ArrayList<>(); 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken()); 
                board[i][j] = input; 
                if(input == 2) virusPosition.add(new int[]{i, j}); 
            }
        }

        dfs(0); 
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void dfs(int count) {
        if(count == 3) {
            int safeCnt = spreadVirus(); 
            answer = Math.max(answer, safeCnt); 
            return; 
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] > 0) continue; 
                board[i][j] = 1; 
                dfs(count + 1); 
                board[i][j] = 0; 
            }
        }
    }

    static int spreadVirus() {
        int[] dirx = {0, 0, 1, -1}; 
        int[] diry = {1, -1, 0, 0}; 
        Queue<int[]> viruses = new ArrayDeque<>(); 
        ArrayList<int[]> spreadList = new ArrayList<>(); 

        for(int[] pos : virusPosition) {
            viruses.offer(pos); 
        }

        while(!viruses.isEmpty()) {
            int[] tmp = viruses.poll(); 
            for(int d = 0; d < 4; d++) {
                int nx = tmp[0] + dirx[d]; 
                int ny = tmp[1] + diry[d]; 

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] > 0) continue; 
                int[] nxt = new int[] {nx, ny}; 
                spreadList.add(nxt);
                viruses.offer(nxt); 
                board[nx][ny] = 2;  
            }
        }

        int safeCnt = checkSafeArea(); 

        for(int[] pos: spreadList) {
            board[pos[0]][pos[1]] = 0; 
        }

        return safeCnt; 
    }

    static int checkSafeArea() {
        int cnt = 0; 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 0) cnt++; 
            }
        }
        return cnt; 
    }
}