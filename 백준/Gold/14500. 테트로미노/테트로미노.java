import java.io.*;
import java.util.*;
class Main {
    static int[] dirx = { 0, 1, 0, -1 }; 
    static int[] diry = { -1, 0, 1, 0 }; 
    static int N, M, maxSum; 
    static int[][] board; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        maxSum = 0; 
        board = new int[N][M]; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        solution(); 
        getSumFuckyouType(); 
        bw.write(maxSum + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    public static void solution() {
        boolean[][] visited = new boolean[N][M]; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true; 
                dfs(visited, i, j, 1, board[i][j]); 
                visited[i][j] = false; 
            }
        }
    }

    public static void dfs(boolean[][] visited, int x, int y, int cnt, int sum) {
        if(cnt == 4) {
            maxSum = Math.max(maxSum, sum); 
            return; 
        }

        for(int d = 0; d < 4 ; d++) {
            int nx = x + dirx[d]; 
            int ny = y + diry[d]; 

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue; 
            visited[nx][ny] = true; 
            dfs(visited, nx, ny, cnt + 1, sum + board[nx][ny]); 
            visited[nx][ny] = false; 
        }
    }

    public static void getSumFuckyouType() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int sum = 0; 
                for(int k = i - 1; k <= i + 1; k++) {
                    if(k < 0 || k >= N) break; 
                    sum += board[k][j]; 
                }
                if(j + 1 < M) {
                    maxSum = Math.max(maxSum, sum + board[i][j + 1]); 
                } 
                if(j - 1 >= 0) {
                    maxSum = Math.max(maxSum, sum + board[i][j - 1]); 
                }
                sum = 0; 
                for(int k = j - 1; k <= j + 1; k++) {
                    if(k < 0 || k >= M) break; 
                    sum += board[i][k]; 
                }
                if(i + 1 < N) {
                    maxSum = Math.max(maxSum, sum + board[i + 1][j]); 
                } 
                if(i - 1 >= 0) {
                    maxSum = Math.max(maxSum, sum + board[i - 1][j]); 
                }
            }
        }
    }
}