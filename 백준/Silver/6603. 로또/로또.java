import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int n = Integer.parseInt(st.nextToken()); 

            if(n == 0) break; 

            int[] arr = new int[n]; 

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); 
            }

            func(0, 0, new int[6], arr); 
            sb.append("\n"); 
        }
        bw.write(sb.toString()); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void func(int cnt, int idx, int[] seq, int[] arr) {
        if(cnt == 6) {
            for(int num: seq) {
                sb.append(num).append(" "); 
            }
            sb.append("\n"); 
            return; 
        }

        if(idx >= arr.length) return; 

        for(int i = idx; i < arr.length; i++) {
            seq[cnt] = arr[i]; 
            func(cnt + 1, i + 1, seq, arr); 
        }
    }
}
