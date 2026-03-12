import java.io.*;
import java.util.*;

public class Main {
    static int N, maxScore; 
    static int[][] inings; 
    final static int CNT = 10; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        inings = new int[N][CNT]; 
        StringTokenizer st; 
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 1; j < CNT; j++) {
                inings[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        solution(); 
        bw.write(maxScore + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void solution() {
        boolean[] visited = new boolean[CNT]; 
        visited[1] = true; 
        int[] order = new int[CNT]; 
        order[3] = 1; 

        getOrder(0, visited, order); 
    }

    private static void getOrder(int cnt, boolean[] visited, int[] order) {
        if(cnt == 9) {
            int score = getScore(order); 
            maxScore = Math.max(score, maxScore); 
            return; 
        }

        for(int i = 2; i < CNT; i++) {
            if(visited[i]) continue; 
            visited[i] = true; 
            order[cnt] = i; 
            if(cnt == 2) getOrder(cnt + 2, visited, order); 
            else getOrder(cnt + 1, visited, order); 
            visited[i] = false; 
        }
    }

    private static int getScore(int[] order) {
        int tmpIdx = 0; 
        int score = 0; 
         
        for(int[] ining: inings) {
            int out = 0; 
            int b1 = 0, b2 = 0, b3 = 0; // 1루, 2루, 3루
            while(out < 3) {
                int tmpPlayer = order[tmpIdx]; 
                int tmp = ining[tmpPlayer];  //  현재 결과 
                if(tmp == 0) out++;
                else if (tmp == 1) {
                    score += b3; 
                    b3 = b2; 
                    b2 = b1; 
                    b1 = 1; 
                } else if(tmp == 2) {
                    score += b3 + b2; 
                    b3 = b1; b2 = 1; b1 = 0; 

                } else if (tmp == 3) {
                    score += b3 + b2 + b1; 
                    b3 = 1; b2 = b1 = 0; 
                } else {
                    score += b3 + b2 + b1 + 1; 
                    b3 = b2 = b1 = 0; 
                }
                tmpIdx = (tmpIdx + 1) % 9; 
            }
        }
        return score; 
    }
}