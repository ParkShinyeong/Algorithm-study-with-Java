import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N]; 
        int[] B = new int[M]; 
        
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }

        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken()); 
        }
       

        int idxA = 0, idxB = 0, idx = 0; 
        int[] answer = new int[N + M]; 

        while(idxA < N && idxB < M) {
            if(A[idxA] < B[idxB]) {
                answer[idx++] = A[idxA++]; 
            } else {
                answer[idx++] = B[idxB++]; 
            }
        }

        while(idxA < N) {
            answer[idx++] = A[idxA++]; 
        }
        while(idxB < M) {
            answer[idx++] = B[idxB++]; 
        }

        for(int i = 0; i < N + M; i++) {
            bw.write(answer[i] + " "); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}