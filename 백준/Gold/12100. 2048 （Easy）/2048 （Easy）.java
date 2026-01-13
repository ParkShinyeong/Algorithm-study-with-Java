import java.io.*;
import java.util.*;

public class Main {
    static int N, answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
       
        N = Integer.parseInt(br.readLine()); 
        answer = 0; 
        int[][] board = new int[N][N]; 
        StringTokenizer st; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        dfs(0, board); 
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void dfs(int cnt, int[][] board) {
        if(cnt == 5) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    answer = Math.max(board[i][j], answer); 
                }
            }
            return; 
        }
        
        for(int i = 0; i < 4; i++) {
            board = rotateBoard(board); 
            int[][] nxt = moveBoard(board); 
            dfs(cnt + 1, nxt); 
        }
    }

    static int[][] moveBoard(int[][] board) {
        int[][] nxt = new int[N][N]; 

        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new ArrayDeque<>(); 
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue; 
                q.offer(board[i][j]); 
            }

            for(int j = 0; j < N; j++) {
                if(q.isEmpty()) {
                    nxt[i][j] = 0; 
                    continue; 
                }

                int tmp = q.poll(); 
                if(!q.isEmpty() && tmp == q.peek()) {
                    q.poll(); 
                    nxt[i][j] = tmp * 2; 
                } else {
                    nxt[i][j] = tmp; 
                }
            }
        }
        return nxt; 
    }

    static int[][] rotateBoard(int[][] board) {
        int[][] nxtBoard = new int[N][N]; 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                nxtBoard[j][N - 1 - i] = board[i][j]; 
            }
        }

        return nxtBoard; 
    }
}