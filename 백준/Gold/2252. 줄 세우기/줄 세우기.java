import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[] indegrees; 
    static ArrayList<Integer>[] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        indegrees = new int[N + 1]; 
        graph = new ArrayList[N + 1]; 
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int s1 = Integer.parseInt(st.nextToken()); 
            int s2 = Integer.parseInt(st.nextToken()); 
            indegrees[s2]++; 
            graph[s1].add(s2); 
        }

        bw.write(solution()); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static String solution() {
        Queue<Integer> queue = new ArrayDeque<>(); 
        for(int i = 1; i <= N; i++) {
            if(indegrees[i] == 0) queue.offer(i); 
        }

        int[] answer = new int[N]; 
        int idx = 0; 

        while(!queue.isEmpty()) {
            int tmp = queue.poll(); 
            answer[idx++] = tmp; 
            for(int nxt: graph[tmp]) {
                indegrees[nxt]--; 
                if(indegrees[nxt] == 0) queue.offer(nxt); 
            }
        }

        StringBuilder sb = new StringBuilder(); 
        for(int n: answer) {
            sb.append(n).append(" "); 
        }

        return sb.toString(); 
    }
}