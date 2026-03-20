import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<Integer>[] graph; 
    static int[] counts; 
    static boolean[] isVisit; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
    
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        graph = new ArrayList[N + 1]; 

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int v1 = Integer.parseInt(st.nextToken()); 
            int v2 = Integer.parseInt(st.nextToken()); 
            graph[v1].add(v2); 
        }

        counts = new int[N + 1]; 
        isVisit = new boolean[N + 1]; 

        for(int i = 1; i <= N; i++) {
            Arrays.fill(isVisit, false); 
            bfs(i); 
        }

        int max = 0; 
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, counts[i]);
        }

        StringBuilder sb = new StringBuilder(); 
        for(int i = 1; i <= N; i++) {
            if(max == counts[i]) sb.append(i).append(" "); 
        }
        bw.write(sb.toString()); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void bfs(int root) {
        int[] queue = new int[N + 1]; 
        queue[0] = root; 

        isVisit[root] = true; 

        int head = 0, tail = 1; 

        while(tail <= N && head < tail) {
            int tmp = queue[head++]; 
            for(int nxt: graph[tmp]) {
                if(isVisit[nxt]) continue; 
                isVisit[nxt] = true; 
                queue[tail++] = nxt; 
                counts[nxt]++; 
            }
        }
    }
}