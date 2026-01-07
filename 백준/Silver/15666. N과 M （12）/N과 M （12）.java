import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static TreeSet<Integer> set; 
    static int[] arr; 
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine()); 
        set = new TreeSet<>(); 

        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken())); 
        }
        arr = set.stream().mapToInt(Integer::valueOf).toArray(); 

        recur(0, 0, new int[M]); 

        bw.write(sb.toString()); 

        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int cnt, int prevIdx, int[] seq) {
        if(cnt == M) {
            for(int num: seq) {
                sb.append(num).append(" "); 
            }
            sb.append("\n"); 
            return; 
        }

        for(int i = prevIdx; i < arr.length; i++) {
            seq[cnt] = arr[i]; 
            recur(cnt + 1, i, seq); 
        }
    }
}
