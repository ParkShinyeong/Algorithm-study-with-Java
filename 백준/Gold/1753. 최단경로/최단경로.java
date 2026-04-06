import java.io.*;
import java.util.*;

public class Main {
    static int V, E, START;
    static ArrayList<Node>[] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        V = Integer.parseInt(st.nextToken()); 
        E = Integer.parseInt(st.nextToken()); 
        START = Integer.parseInt(br.readLine()); 
        graph = new ArrayList[V + 1]; 

        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost)); 
        }
        
        int[] ans = solution(); 
        for(int i = 1; i <= V; i++) {
            if(ans[i] == Integer.MAX_VALUE) bw.write("INF\n"); 
            else bw.write(ans[i] + "\n"); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int[] solution() {
        int[] length = new int[V + 1]; 
        Arrays.fill(length, Integer.MAX_VALUE); 
        length[START] = 0; 

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        pq.offer(new Node(START, 0)); 

        while(!pq.isEmpty()) {
            Node tmp = pq.poll(); 
            if(tmp.cost > length[tmp.value]) continue; 
            length[tmp.value] = tmp.cost; 

            for(Node nxt: graph[tmp.value]) {
                int cost = tmp.cost + nxt.cost;
                if(length[nxt.value] <= cost) continue; 
                length[nxt.value] = cost;  
                pq.offer(new Node(nxt.value, cost)); 
            }
        }
        
        return length; 
    }
}

class Node {
    int value, cost; 
    Node(int value, int cost) {
        this.value = value; 
        this.cost = cost; 
    }
}