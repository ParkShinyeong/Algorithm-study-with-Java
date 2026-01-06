import java.io.*;
import java.util.*;

public class Main {
    static char[][] board; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 
        board = new char[N][N * 2 - 1]; 
        for(int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' '); 
        }
        recur(0, N - 1, N); 
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < N; i++) {
            sb.append(board[i]).append("\n");  
        }
        bw.write(sb.toString()); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int sx, int sy, int n) {
        if(n == 3) {
            board[sx][sy] = '*';
            board[sx + 1][sy - 1] = board[sx + 1][sy + 1] = '*'; 
            for(int i = sy - 2; i <= sy + 2; i++) {
                board[sx + 2][i] = '*'; 
            }
            return; 
        }   
        int nxt = n / 2; 
        recur(sx, sy, nxt); 
        recur(sx + nxt, sy - nxt, nxt); 
        recur(sx + nxt, sy + nxt, nxt); 
    }
}
