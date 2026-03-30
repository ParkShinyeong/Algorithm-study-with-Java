import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[][] board; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); 
        board = new int[N][N]; 
        StringTokenizer st; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int[][] sandirx = {
            {1, -1, 1, -1, 2, -2, 1, -1, 0, 0}, 
            {0, 0, 1, 1, 0, 0, -1, -1, 2, 1}, 
            {1, -1, 1, -1, 2, -2, 1, -1, 0, 0},
            {0, 0, -1, -1, 0, 0, 1, 1, -2, -1}}; 
        int[][] sandiry = {
            {0, 0, -1, -1, 0, 0, 1, 1, -2, -1}, 
            {1, -1, 1, -1, 2, -2, 1, -1, 0, 0}, 
            {0, 0, 1, 1, 0, 0, -1, -1, 2, 1}, 
            {1, -1, 1, -1, 2, -2, 1, -1, 0, 0}}; 
        int[] percent = {7, 7, 10, 10, 2, 2, 1, 1, 5}; 
        int[] dirx = {0, 1, 0, -1}; 
        int[] diry =  {-1, 0, 1, 0}; 

        int tx = N / 2; 
        int ty = N / 2; 

        int totalOut = 0; 
        int cnt = 1; 
        int tmpDir = 0; 

        while(true) {
            for(int i = 0; i < 2; i++) {
                for(int c = 0; c < cnt; c++) {
                    int nx = tx + dirx[tmpDir]; 
                    int ny = ty + diry[tmpDir]; 
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        return totalOut;
                    }
                    int sand = board[nx][ny]; 
                    int vanishSand = 0; 

                    for(int d = 0; d < sandirx[0].length - 1; d++) {
                        int nnx = nx + sandirx[tmpDir][d]; 
                        int nny = ny + sandiry[tmpDir][d]; 
                        int p = percent[d]; 
                        int tmpSand = sand * p / 100; 
                        vanishSand += tmpSand; 
                        if(nnx < 0 || nny < 0 || nnx >= N || nny >= N) {
                            totalOut += tmpSand; 
                            continue; 
                        }
                        board[nnx][nny] += tmpSand; 

                    }
                    board[nx][ny] = 0; 
                    int nnx = nx + sandirx[tmpDir][sandirx[0].length - 1]; 
                    int nny = ny + sandiry[tmpDir][sandiry[0].length - 1]; 
                    if(nnx < 0 || nny < 0 || nnx >= N || nny >= N) totalOut += (sand - vanishSand); 
                    else board[nnx][nny] += (sand - vanishSand); 
                    tx = nx; 
                    ty = ny; 
                }
                tmpDir = (tmpDir + 1) % 4; 
            }
            if(tx == 0 && ty == 0) break; 
            cnt++; 
        }
        return totalOut; 
    }
}