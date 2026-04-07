import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<Edge>[] graph; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine()); 

        graph = new ArrayList[N + 1]; 

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        StringTokenizer st; 

        for(int i= 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken()); 
            int end = Integer.parseInt(st.nextToken()); 
            int cost = Integer.parseInt(st.nextToken()); 
            graph[start].add(new Edge(end, cost)); 
        }

        st = new StringTokenizer(br.readLine()); 
        int start = Integer.parseInt(st.nextToken()); 
        int end = Integer.parseInt(st.nextToken()); 

        bw.write(solution(start, end)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static String solution(int start, int end) {
        int[] lengths = new int[N + 1]; 
        Arrays.fill(lengths, Integer.MAX_VALUE); 
        int[] prevNode = new int[N + 1]; 
        lengths[start] = 0; 
        prevNode[start] = start; 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        pq.offer(new int[] { start, 0 }); 

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll(); 
            if(lengths[tmp[0]] < tmp[1]) continue; 
            lengths[tmp[0]] = tmp[1]; 

            for(Edge nxt: graph[tmp[0]]) {
                int len = tmp[1] + nxt.cost; 
                if(lengths[nxt.node] <= len) continue; 
                lengths[nxt.node] = len; 
                pq.offer(new int[] {nxt.node, len}); 
                prevNode[nxt.node] = tmp[0]; 
            }
        }

        int cnt = 1; 
        Stack<Integer> path = new Stack<>(); 
        int tmp = end; 
        path.add(tmp); 

        while(true) {
            if(prevNode[tmp] == tmp) break; 
            path.add(prevNode[tmp]); 
            tmp = prevNode[tmp]; 
            cnt++; 
        }

        StringBuilder answer = new StringBuilder(); 
        answer.append(lengths[end]).append("\n").append(cnt).append("\n"); 

        while(!path.isEmpty()) {
            answer.append(path.pop()).append(" "); 
        }

        return answer.toString(); 
        
    }
}

class Edge {
    int node, cost; 
    Edge (int node, int cost) {
        this.node = node; 
        this.cost = cost; 
    }
}