import java.io.*;
import java.util.*;

public class Main {
    static int n, m; 
    static boolean[] visited; 
    static int[] arr, output; 
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 

        arr = new int[n]; 
        visited = new boolean[n]; 
        output = new int[m]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(arr); 
        dfs(0); 

        bw.write(sb.toString()); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if(depth >= m) {
            for(int num: output) {
                sb.append(num); 
                sb.append(" "); 
            }
            sb.append("\n"); 
            return;
        }
        int prev = -1; 

        for(int i = 0; i < arr.length; i++) {
            if(visited[i] || arr[i] == prev) continue; 

            visited[i] = true; 
            output[depth] = arr[i]; 
            prev = arr[i]; 

            dfs(depth + 1); 

            visited[i] = false; 
        }
    }
}
