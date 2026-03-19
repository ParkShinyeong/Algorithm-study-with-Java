import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static boolean[] isChild; 
    static ArrayList<Integer>[] tree; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1]; 
        isChild = new boolean[N + 1]; 
        
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>(); 
        }
        StringTokenizer st; 

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int p = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            // parents[c] = p; 
            tree[p].add(c); 
            tree[c].add(p); 
        }

        boolean[] isVisit = new boolean[N + 1]; 
        int[][] dp = new int[N + 1][2]; 
        isVisit[1] = true; 
        dfs(1, dp, isVisit);
        int root = 0; 
        for(int i = 1; i <= N; i++) {
            if(!isChild[i]) root = i; 
        }
        
        bw.write(Math.min(dp[root][0], dp[root][1]) + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int node, int[][] dp, boolean[] isVisit) {
        for(int nxt: tree[node]) {
            if(isVisit[nxt]) continue; 
            isVisit[nxt] = true; 
            isChild[nxt] = true; 
            dfs(nxt, dp, isVisit); 
        }

        for(int nxt: tree[node]) {
            dp[node][0] += dp[nxt][1]; 
            dp[node][1] += Math.min(dp[nxt][0], dp[nxt][1]); 
        }
        dp[node][1]++; 
    }
}