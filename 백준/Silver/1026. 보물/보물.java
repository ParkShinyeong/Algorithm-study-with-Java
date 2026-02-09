import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 

        int[] a = new int[N]; 
        int[] b = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken()); 
        }
        
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(a); 
        Arrays.sort(b);
        
        int ans = 0; 
        for(int i = 0; i < N; i++) {
            ans += a[i] * b[N - 1 - i]; 
        }
        
        bw.write(ans + "");
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}