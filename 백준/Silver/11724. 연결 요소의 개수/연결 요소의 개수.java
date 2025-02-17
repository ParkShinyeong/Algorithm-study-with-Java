import java.io.*; 
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int cnt; 
    static ArrayList<ArrayList<Integer>> gp; 
    static int[] used; 
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gp = new ArrayList<>(); 
        for(int i = 0; i <= N; i++) {
            gp.add(new ArrayList<>()); 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
           gp.get(u).add(v); 
           gp.get(v).add(u); 
        }
        used = new int[N + 1]; 
        
        for(int i = 1; i <= N; i++) {
            if(used[i] == 0) { // 방문하지 않은 노드면 새로운 연결 요소 발견 
                dfs(i); 
                cnt++; 
            }
        }
        bw.write(cnt + ""); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node) {
        if(used[node] == 1) {
            return; 
        }
        used[node] = 1; 
        for(int next: gp.get(node)) {
            if(used[next] == 0) {
                dfs(next); 
            }
        }
        
    }
}
