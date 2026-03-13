import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 

        for(int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine()); 
            int V = Integer.parseInt(st.nextToken()); 
            int E = Integer.parseInt(st.nextToken()); 
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V + 1);  

            for(int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>()); 
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine()); 
                int v1 = Integer.parseInt(st.nextToken()); 
                int v2 = Integer.parseInt(st.nextToken()); 
                graph.get(v1).add(v2); 
                graph.get(v2).add(v1); 
            }
            boolean flag = solution(V, E, graph); 
            if(!flag) bw.write("NO\n"); 
            else bw.write("YES\n");
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static boolean solution(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        int[] checkCloseNode = new int[V + 1]; 
        Queue<int[]> queue = new ArrayDeque<>(); 
        int tmpGroup = 1; 
        
        for(int i = 1; i <= V; i++) {
            if(checkCloseNode[i] != 0) continue; 
            queue.offer(new int[] {i, tmpGroup}); 
            checkCloseNode[i] = tmpGroup; 
            
            while(!queue.isEmpty()) {
                int[] tmp = queue.poll(); 
                int node = tmp[0]; 
                int group = tmp[1]; 
                
                for(int nv : graph.get(node)) {
                    if(checkCloseNode[nv] == group) {
                        return false; 
                    }
                    if(checkCloseNode[nv] != 0) continue; 
                    checkCloseNode[nv] = -group; 
                    queue.offer(new int[]{nv, -group}); 
                }
            }
        }
        return true; 
    }

}