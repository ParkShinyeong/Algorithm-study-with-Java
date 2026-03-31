import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static PriorityQueue<Edge> upperPq; 
    static PriorityQueue<Edge> lowerPq; 
    static int[] parents; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        

        upperPq = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        lowerPq = new PriorityQueue<>((a, b) -> b.cost - a.cost); 

        for(int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken()); 
            int end = Integer.parseInt(st.nextToken()); 
            int cost = Integer.parseInt(st.nextToken()); 
            Edge edge = new Edge(start, end, cost); 
            upperPq.offer(edge); 
            lowerPq.offer(edge); 
        }

        parents = new int[N + 1]; 
        Arrays.fill(parents, -1); 
        int worst = getWorst(); 
        Arrays.fill(parents, -1); 
        int best = getBest(); 

        bw.write(worst - best + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int getWorst() {
        int fatigue = 0; 
        int edgeCnt = 0; 
        while(!upperPq.isEmpty()) {
            Edge tmp = upperPq.poll(); 
            if(!union(tmp.start, tmp.end)) continue; 
            if(tmp.cost == 0) fatigue++; 
            edgeCnt++; 
            if(edgeCnt == N) break; 
        }

        return fatigue * fatigue;
    }

    private static int getBest() {
        int fatigue = 0; 
        int edgeCnt = 0; 
        while(!lowerPq.isEmpty()) {
            Edge tmp = lowerPq.poll(); 
            if(!union(tmp.start, tmp.end)) continue; 
            if(tmp.cost == 0) fatigue++; 
            edgeCnt++; 
            if(edgeCnt == N) break; 
        }

        return fatigue * fatigue;
    }

    private static boolean union(int n1, int n2) {
        int p1 = find(n1); 
        int p2 = find(n2); 

        if(p1 == p2) return false; 
        parents[p1] = find(p2); 
        return true; 
    }

    private static int find(int n) {
        if(parents[n] < 0) return n; 
        return parents[n] = find(parents[n]); 
    }
}

class Edge {
    int start, end, cost; 
    Edge(int start, int end, int cost) {
        this.start = start; 
        this.end = end; 
        this.cost = cost; 
    }
}