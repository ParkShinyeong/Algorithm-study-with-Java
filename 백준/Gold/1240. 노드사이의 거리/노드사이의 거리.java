import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<int[]>[] graph; 
    static int[] parents, depths, lengths; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        graph = new ArrayList[N + 1]; 

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int p = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            int len = Integer.parseInt(st.nextToken()); 
            
            graph[p].add(new int[] {c, len}); 
            graph[c].add(new int[] {p, len}); 
        }
        
        makeTree(); 

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            int LCA = getLCA(n1, n2); 

            int answer = lengths[n1] + lengths[n2] - 2 * lengths[LCA]; 

            bw.write(answer + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

   private static void makeTree() {
        int root = 1; 
        parents = new int[N + 1]; 
        depths = new int[N + 1];
        lengths = new int[N + 1]; 
        
        Queue<Integer> q = new ArrayDeque<>(); 
        q.offer(root); 

        boolean[] isVisited = new boolean[N + 1]; 
        isVisited[root] = true; 

        while(!q.isEmpty()) {
            int tmp = q.poll(); 

            for(int[] nxtNode: graph[tmp]) {
                int nxt = nxtNode[0]; 
                if(isVisited[nxt]) continue; 
                isVisited[nxt] = true; 
                q.offer(nxt); 
                parents[nxt] = tmp; 
                depths[nxt] = depths[tmp] + 1; 
                lengths[nxt] = lengths[tmp] + nxtNode[1]; 
            }
        }
   }

   private static int getLCA(int n1, int n2) {
    // 깊이 맞추기 
        while(depths[n1] > depths[n2]) n1 = parents[n1]; 
        while(depths[n2] > depths[n1]) n2 = parents[n2]; 

        // 최소 공통 조상 찾기 
        while(n1 != n2) {
            n1 = parents[n1]; 
            n2 = parents[n2]; 
        }

        return n1; 
   }
}
