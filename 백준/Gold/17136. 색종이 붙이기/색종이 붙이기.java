import java.io.*;
import java.util.*;

public class Main {
    static final int N = 10; 
    static int min = Integer.MAX_VALUE; 
    static int[][] board = new int[N][N]; 
    static ArrayList<Position> ones = new ArrayList<>(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
                if(board[i][j] == 1) {
                    ones.add(new Position(i, j)); 
                } 
            }
        }
        solution();
        if(min == Integer.MAX_VALUE) bw.write("-1"); 
        else bw.write(min + ""); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void solution() {
        boolean[][] visit = new boolean[N][N]; 
        int[] paperCnt = new int[6];
        Arrays.fill(paperCnt, 5);  
        dfs(0, paperCnt, 0, visit, 0); 
        
    }

    private static void dfs(int idx, int[] paperCnt, int totalCnt, boolean[][] visit, int coverCnt) {
        if(totalCnt >= min) return; 
        if(coverCnt == ones.size()) {
            min = Math.min(min, totalCnt);
            return; 
        }

        Position pos = ones.get(idx); 
        if(visit[pos.x][pos.y]) dfs(idx + 1, paperCnt, totalCnt, visit, coverCnt); 
        
        for(int i = 5; i > 0; i--) {
            if(!check(visit, pos, i)) continue; 
            if(paperCnt[i] - 1 < 0) continue; 

            visitPaper(visit, pos, i); 
            paperCnt[i]--; 

            dfs(idx + 1, paperCnt, totalCnt + 1, visit, coverCnt + i * i); 

            returnPaperStatus(visit, pos, i); 
            paperCnt[i]++; 
        }
    }
    
    private static boolean check(boolean[][] visit, Position start, int size) {
        for(int i = size - 1; i >= 0; i--) {
            for(int j = size - 1; j >= 0; j--) {
                int nx = start.x + i; 
                int ny = start.y + j; 
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || 
                    visit[nx][ny] || board[nx][ny] == 0) return false; 
            }
        }
        return true; 
    }

    private static void visitPaper(boolean[][] visit, Position start, int size) {
        for(int i = size - 1; i >= 0; i--) {
            for(int j = size - 1; j >= 0; j--) {
                int nx = start.x + i; 
                int ny = start.y + j; 
                visit[nx][ny] = true; 
            }
        }
    }

    private static void returnPaperStatus(boolean[][] visit, Position start, int size) {
        for(int i = size - 1; i >= 0; i--) {
            for(int j = size - 1; j >= 0; j--) {
                int nx = start.x + i; 
                int ny = start.y + j; 
                visit[nx][ny] = false; 
            }
        }
    }
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}
