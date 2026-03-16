import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<ConnectNode>[] graph; 
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

            graph[p].add(new ConnectNode(c, len)); 
            graph[c].add(new ConnectNode(p, len)); 
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            bw.write(solution(n1, n2) + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution(int n1, int n2) {
        Queue<Integer> queue = new ArrayDeque<>(); 
        queue.offer(n1); 
        boolean[] isVisited = new boolean[N + 1]; 
        int[] lengths = new int[N + 1]; 
        while(!queue.isEmpty()) {
            int tmp = queue.poll(); 
            if(tmp == n2) break; 
            
            for(ConnectNode node: graph[tmp]) {
                if(isVisited[node.nxt]) continue; 
                isVisited[node.nxt] = true; 
                lengths[node.nxt] = node.length + lengths[tmp]; 
                queue.offer(node.nxt); 
            }
        }

        return lengths[n2]; 
    }
}

class ConnectNode {
    int nxt, length; 
    ConnectNode(int nxt, int length) {
        this.nxt = nxt; 
        this.length = length; 
    }

}