import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[] A; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        A = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(A); 
        int M = Integer.parseInt(br.readLine()); 

        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken()); 
            bw.write(isExisted(m) + "\n"); 
        }
        
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static int isExisted(int n) {
        int st = 0; 
        int ed = N - 1; 

        while(st <= ed) {
            int mid = (st + ed) / 2; 

            if(A[mid] == n) return 1; 
            else if (A[mid] < n) st = mid + 1; 
            else ed = mid - 1; 
        }

        return 0;
    }
}