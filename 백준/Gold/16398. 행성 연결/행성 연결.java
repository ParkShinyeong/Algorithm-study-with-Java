import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[][] cost; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        cost = new int[N][N]; 
        StringTokenizer st; 
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static long solution() {
        int start = 0; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        boolean[] visit = new boolean[N]; 
        visit[start] = true; 

        for(int i = 1; i < N; i++) {
            pq.offer(new int[] {i, cost[start][i]}); 
        }

        long total = 0; 
        int edgeCnt = 0; 
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll(); 
            int node = tmp[0]; 
            int tmpCost = tmp[1]; 

            if(visit[node]) continue; 
            
            visit[node] = true; 
            total += tmpCost; 
            edgeCnt++; 

            if(edgeCnt == N - 1) break; 

            for(int i = 0; i < N; i++) {
                if(visit[i]) continue; 
                pq.offer(new int[] {i, cost[node][i]});
            }
        }

        return total; 
    }
}