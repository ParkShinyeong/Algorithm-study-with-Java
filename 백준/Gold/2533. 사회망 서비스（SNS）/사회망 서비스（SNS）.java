import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static ArrayList<Integer>[] graph; 
    static int[][] dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1]; 
        
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }
        StringTokenizer st; 

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int p = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            graph[p].add(c); 
            graph[c].add(p); 
        }

        dp = new int[N + 1][2]; 

        dfs(1, 0);
        
        bw.write(Math.min(dp[1][0], dp[1][1]) + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int node, int parent) {
        dp[node][1] = 1; 
        for(int nxt: graph[node]) {
            if(nxt == parent) continue; 
            dfs(nxt, node); 

            dp[node][0] += dp[nxt][1]; 
            dp[node][1] += Math.min(dp[nxt][0], dp[nxt][1]); 
        }
    }
}