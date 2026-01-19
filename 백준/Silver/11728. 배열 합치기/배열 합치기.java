import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            // .sorted()
            .toArray(); 
        int[] B = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            // .sorted()
            .toArray();
        br.close(); 
        ArrayList<Integer> sortedArr = new ArrayList(); 

        int ia = 0, ib = 0; 
        while(ia < N && ib < M) {
            if(A[ia] < B[ib]) {
                sortedArr.add(A[ia]); 
                ia++; 
            } else {
                sortedArr.add(B[ib]); 
                ib++; 
            } 
        }

        if(ia == N) {
            for(int i = ib; i < M; i++) {
                sortedArr.add(B[i]); 
            }
        } else if (ib == M) {
            for(int i = ia; i < N; i++) {
                sortedArr.add(A[i]); 
            }
        }
        
        for(Integer num: sortedArr) {
            bw.write(num + " "); 
        }
        bw.flush(); 
        bw.close(); 
    }
}