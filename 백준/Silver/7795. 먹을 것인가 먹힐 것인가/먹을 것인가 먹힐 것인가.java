import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int T = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine()); 
            int A = Integer.parseInt(st.nextToken()); 
            int B = Integer.parseInt(st.nextToken()); 

            int[] arrA = new int[A]; 
            int[] arrB = new int[B]; 

            st = new StringTokenizer(br.readLine()); 
            for(int i = 0; i < A; i++) {
                arrA[i] = Integer.parseInt(st.nextToken()); 
            }
            
            st = new StringTokenizer(br.readLine()); 
            for(int i = 0; i < B; i++) {
                arrB[i] = Integer.parseInt(st.nextToken()); 
            }
            bw.write(solution(A, B, arrA, arrB) + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static int solution(int A, int B, int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB); 

        int cnt = 0; 
        int b = 0; 
        for(int a = 0; a < A; a++) {
            while(b < B && arrB[b] < arrA[a]) b++; 
            cnt += b; 
        }
        return cnt; 
    }
}