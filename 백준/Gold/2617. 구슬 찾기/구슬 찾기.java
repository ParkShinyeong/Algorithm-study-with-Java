import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static ArrayList<Integer>[] upper; 
    static ArrayList<Integer>[] lower; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        upper = new ArrayList[N + 1]; 
        lower = new ArrayList[N + 1]; 

        for(int i = 1; i <= N; i++) {
            upper[i] = new ArrayList<>(); 
            lower[i] = new ArrayList<>(); 
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int b = Integer.parseInt(st.nextToken()); 
            int s = Integer.parseInt(st.nextToken()); 

            upper[s].add(b); 
            lower[b].add(s); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int mid = (N + 1) / 2; 
        int count = 0; 

        for(int ball = 1; ball <= N; ball++) {
            if(getBallCount(ball, lower) >= mid || getBallCount(ball, upper) >= mid) count++; 
        }
        return count; 

    }

    private static int getBallCount(int ball, ArrayList<Integer>[] graph) {
        Queue<Integer> balls = new ArrayDeque<>(); 
        balls.offer(ball); 

        boolean[] isVisited = new boolean[N + 1]; 
        isVisited[ball] = true; 

        int cnt = 0; 

        while(!balls.isEmpty()) {
            int tmp = balls.poll(); 
            
            for(int nxt: graph[tmp]) {
                if(isVisited[nxt]) continue; 
                cnt++; 
                balls.offer(nxt); 
                isVisited[nxt] = true; 
            }
        }
        return cnt; 

    }
}