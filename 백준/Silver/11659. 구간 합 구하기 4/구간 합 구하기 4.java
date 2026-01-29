import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int T = Integer.parseInt(st.nextToken()); 

        int[] sum = new int[N + 1]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken()); 
        }

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine()); 
            int i = Integer.parseInt(st.nextToken()); 
            int j = Integer.parseInt(st.nextToken()); 

            bw.write(sum[j] - sum[i - 1] + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}