import java.io.*;

public class Main {
    static char[][] board; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 
        board = new char[N][N * 2 - 1]; 
        recur(0, N - 1, N); 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N * 2 - 1; j++) {
                bw.write(board[i][j] == '*' ? '*' : ' '); 
            }
            bw.write("\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int sx, int sy, int n) {
        if(n == 3) {
            board[sx][sy] = '*';
            board[sx + 1][sy - 1] = '*'; 
            board[sx + 1][sy + 1] = '*'; 
            for(int i = sy - 2; i <= sy + 2; i++) {
                board[sx + 2][i] = '*'; 
            }
            return; 
        }   

        recur(sx, sy, n / 2); 
        recur(sx + n / 2, sy - n / 2, n / 2); 
        recur(sx + n / 2, sy + n / 2, n / 2); 


    }
}
