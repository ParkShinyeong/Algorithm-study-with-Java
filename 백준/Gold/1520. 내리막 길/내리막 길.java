import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static int[][] board;
    static int[] dirx = {0, -1, 0, 1};
    static int[] diry = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        int cnt = dfs(0, 0, dp);
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int x, int y, int[][] dp) {
        if(x == M - 1 && y == N - 1) {
            return 1;
        }

        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;

        for(int d = 0; d < 4; d++) {
            int nx = x + dirx[d];
            int ny = y + diry[d];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N ) continue;
            if(board[x][y] <= board[nx][ny]) continue;
            dp[x][y] += dfs(nx, ny, dp);
        }
        return dp[x][y];
    }


}
