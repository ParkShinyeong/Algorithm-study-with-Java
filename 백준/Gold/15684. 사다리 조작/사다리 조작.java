import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, answer; 
    static boolean[][] isRow; 
    static int[] dir = {1, -1}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 

        isRow = new boolean[H + 1][N]; 
        answer = -1;

        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 

            isRow[a][b] = true; 
        }
        
        dfs(0, 1); 

        bw.write(answer + ""); 
        bw.flush();
        bw.close();
        br.close();
        
    }

    static void dfs(int cnt, int idx) {
        if(cnt > 3) {
            return; 
        }
        if(checkLadders()) {
            if(answer == -1) answer = cnt; 
            else answer = Math.min(answer, cnt); 
            return; 
        }

        for(int i = idx; i <= (N - 1) * H; i++) {
            int x = (i - 1) / (N - 1) + 1; 
            int y = (i - 1) % (N - 1) + 1; 
            if(isRow[x][y] || (y + 1 < N && isRow[x][y + 1]) || (y - 1 > 0 && isRow[x][y - 1])) continue; 
            isRow[x][y] = true; 
            dfs(cnt + 1, i + 1); 
            isRow[x][y] = false; 
        }
    }

    static boolean checkLadders() {
        for(int i = 1; i <= N; i++) {
            if(!checkOneLadder(i)) return false; 
        }
        return true; 
    }

    static boolean checkOneLadder(int start) {
        int tmp = start; 
        for(int i = 1; i <= H; i++) {
            if(tmp < N && isRow[i][tmp]) tmp++; 
            else if (tmp > 1 && isRow[i][tmp - 1]) tmp--; 
        }

        if(start == tmp) return true; 
        return false; 
    }
}