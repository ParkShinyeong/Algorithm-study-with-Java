import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K; 
    static char[][] board; 
    static Map<String, Long> wordCount = new HashMap<>();  
    static int[] dirx = {0, 0, 1, -1, 1, 1, -1, -1}; 
    static int[] diry = {1, -1, 0, 0, 1, -1, 1, -1}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        board = new char[N][M]; 
        
        for(int i = 0; i < N; i++) {
            String input = br.readLine(); 
            for(int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j); 
            }
        }

        solution(); 

        for(int i = 0; i < K; i++) {
            String favorWord = br.readLine(); 
            bw.write(wordCount.getOrDefault(favorWord, 0L) + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void solution() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                StringBuilder sb = new StringBuilder(); 
                sb.append(board[i][j]); 
                dfs(i, j, 0, sb); 
            }
        }
    }

    private static void dfs(int r, int c, int cnt, StringBuilder str) {
        if(cnt >= 5) {
            return; 
        }
        String tmp = str.toString(); 
        wordCount.put(tmp, wordCount.getOrDefault(tmp, 0L) + 1); 
        for(int d = 0; d < 8; d++) {
            int nx = (r + dirx[d] + N) % N; 
            int ny = (c + diry[d] + M) % M; 
            
            str.append(board[nx][ny]); 
            dfs(nx, ny, cnt + 1, str); 
            str.deleteCharAt(cnt + 1); 
        }
    }
}