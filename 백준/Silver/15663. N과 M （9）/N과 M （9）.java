import java.io.*;
import java.util.*;

public class Main {
    static int n, m; 
    static TreeSet<String> results; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[n]; 
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        results = new TreeSet<>(
            (a, b) -> {
            String[] aarr = a.split(" "); 
            String[] barr = b.split(" "); 

            for(int i = 0; i < m; i++) {
                int aa = Integer.parseInt(aarr[i]); 
                int bb = Integer.parseInt(barr[i]); 
                int compareResult = Integer.compare(aa, bb); 
                if(compareResult == 0)continue; 
                return compareResult; 
            }
            return 0; 
        }
    ); 

        dfs(arr, new boolean[n], 0, ""); 
        for(String str : results) {
            bw.write(str); 
            bw.write("\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] arr, boolean[] visited, int depth, String str) {
        if(depth >= m) {
            results.add(str); 
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue; 
            visited[i] = true; 
            dfs(arr, visited, depth + 1, str.length() > 0 ? str + " " + arr[i]: str + arr[i]); 
            visited[i] = false; 
        }
    }
}
