import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[] parents; 
    static PriorityQueue<Edge> pq; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        parents = new int[N + 1]; 
        Arrays.fill(parents, -1); 
        pq = new PriorityQueue<>(); 

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            int cost = Integer.parseInt(st.nextToken()); 
            pq.offer(new Edge(n1, n2, cost)); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int edgeCnt = 0; 
        int total = 0; 
        ArrayList<Integer> costs = new ArrayList<>(); 

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll(); 
            if(!union(tmp.n1, tmp.n2)) continue; 
            
            costs.add(tmp.cost); 
            total += tmp.cost; 
            edgeCnt++; 

            if(edgeCnt == N - 1) break; 
        }

        Collections.sort(costs); 
        total -= costs.get(costs.size() - 1); 
        return total; 

    }

    private static boolean union(int n1, int n2) {
        int p1 = find(n1); 
        int p2 = find(n2); 

        if(p1 == p2) return false; // 이미 같은 집합 
        parents[p1] = find(p2); 
        return true; 
    }

    private static int find(int n) {
        if(parents[n] < 0) return n; 
        return parents[n] = find(parents[n]); 
    }
}

class Edge implements Comparable<Edge> {
    int n1, n2, cost; 
    Edge(int n1, int n2, int cost) {
        this.n1 = n1; 
        this.n2 = n2; 
        this.cost = cost; 
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost; 
    }
}