import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<Integer>[] graph; 
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

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            graph[n1].add(n2); 
            graph[n2].add(n1); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int groupCnt = 0; 
        int removeConnectCount = 0;
        boolean[] isVisit = new boolean[N + 1]; 
        
        for(int i = 1; i <= N; i++) {
            if(isVisit[i]) continue; 
            isVisit[i] = true; 
            int cycle = dfs(i, 0, isVisit) / 2;

            removeConnectCount += cycle; 
            groupCnt++; 
        }
        return removeConnectCount + groupCnt - 1; 
    }

    private static int dfs(int node, int parent, boolean[] isVisit) {
        int cycle = 0; 
        for(int nxt: graph[node]) {
            if(isVisit[nxt]) {
                if(nxt != parent) cycle++; 
                continue; 
            }
            isVisit[nxt] = true; 
            cycle += dfs(nxt, node, isVisit); 
        }
        return cycle; 
    }
}