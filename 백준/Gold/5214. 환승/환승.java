import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M; 
    static ArrayList<Integer>[] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        graph = new ArrayList[N + M + 1]; 
        for(int i = 0; i <= N + M; i++) {
            graph[i] = new ArrayList<>(); 
        }

        for(int tube = N + 1; tube <= N + M; tube++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken()); 
                graph[station].add(tube); 
                graph[tube].add(station); 
            }
        }

        bw.write(solution() + ""); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        Queue<int[]> queue = new ArrayDeque<>(); 
        boolean[] isVisited = new boolean[N + M + 1]; 

        queue.offer(new int[]{1, 1}); 
        isVisited[1] = true; 

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll(); 
            int tmpStation = tmp[0]; 
            if(tmpStation == N) {
                return (tmp[1] / 2) + 1; 
            }

            for(int nxt: graph[tmpStation]) {
                if(isVisited[nxt]) continue; 
                isVisited[nxt] = true; 
                queue.offer(new int[] {nxt, tmp[1] + 1}); 
            }
        }

        return -1; 
    }
}