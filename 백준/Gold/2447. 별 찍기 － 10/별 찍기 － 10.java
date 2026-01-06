import java.io.*;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        board = new char[N][N]; 
        recur(0, 0, N); 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(board[i][j] == '*' ? '*' : ' '); 
            }
            bw.write("\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void recur(int sx, int sy, int n) {
        if(n == 1) {
            board[sx][sy] = '*'; 
            return; 
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) continue; 
                int nxt = n / 3; 
                recur(sx + i * nxt, sy + j * nxt, nxt); 
            }
        }
    }
}
