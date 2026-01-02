import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[][] matrix ; 
    static Map<Integer, Integer> answer; 
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        N = Integer.parseInt(br.readLine()); 

        StringTokenizer st; 
        matrix = new int[N][N]; 
        answer = new HashMap<>(); 

        for(int i = -1 ; i <= 1; i++) {
            answer.put(i, 0); 
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        recur(0, 0, N, N, N); 
    
        for(int i = -1 ; i <= 1; i++) {
            bw.write(answer.get(i) + "\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void recur(int sx, int sy, int ex, int ey, int n) {
        if(n == 1 || isFillWithSameNum(sx, sy, ex, ey)) {
            answer.put(matrix[sx][sy], answer.get(matrix[sx][sy]) + 1); 
            return; 
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int tmp = n / 3; 
                int nx = sx + i * tmp; 
                int ny = sy + j * tmp; 
                recur(nx, ny, nx + tmp, ny + tmp, tmp); 
            }
        }

    }

    static boolean isFillWithSameNum(int sx, int sy, int ex, int ey) {
        if(Math.abs(sx - ex) == 1 || Math.abs(sy - ey) == 1) return true; 

        int prev = matrix[sx][sy]; 
        for(int i = sx; i < ex; i++) {
            for(int j = sy; j < ey; j++) {
                if(prev != matrix[i][j]) return false; 
                prev = matrix[i][j]; 
            }
        }

        return true; 
    }
    
}
