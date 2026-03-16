import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 

        int testcase = 1; 
        while(true) {
            st = new StringTokenizer(br.readLine()); 
            int n = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 

            if(n == 0 && m == 0) break; 

            ArrayList<Integer>[] graph = new ArrayList[n + 1]; 
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<Integer>(); 
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine()); 
                int p = Integer.parseInt(st.nextToken()); 
                int c = Integer.parseInt(st.nextToken()); 
                graph[p].add(c); 
                graph[c].add(p); 
            }

            bw.write("Case " + testcase + ": "); 
            int ans = solution(n, m, graph); 
            if(ans > 1) bw.write("A forest of "+ ans + " trees."); 
            else if(ans == 1) bw.write("There is one tree."); 
            else bw.write("No trees."); 
            bw.write("\n"); 

            testcase++; 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }


    private static int solution(int n, int m, ArrayList<Integer>[] graph) {
        int count = 0; 
        boolean[] visit = new boolean[n + 1]; 
        for(int i = 1; i <= n; i++) {
            if(visit[i]) continue; 
            boolean ans = dfs(i, 0, graph, visit); 
            if(ans) count++; 
        }

        return count; 
    }

    private static boolean dfs(int tmpNode, int parent, ArrayList<Integer>[] graph, boolean[] visit) {
        boolean isTree = true; // 현재 서브트리가 트리인지 여부
        visit[tmpNode] = true; 
    
        for(int nxt : graph[tmpNode]) {
            if(visit[nxt]) {
                if(nxt != parent) {
                    isTree = false; 
                }
            } else {
                if(!dfs(nxt, tmpNode, graph, visit)) {
                    isTree = false;
                }
            }
        }
        return isTree;
    }
}