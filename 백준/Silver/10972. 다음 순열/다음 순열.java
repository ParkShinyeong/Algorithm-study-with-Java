import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[] perm; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        N = Integer.parseInt(br.readLine()); 
        perm = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i= 0; i < N; i++) {
            perm[i] = Integer.parseInt(st.nextToken()); 
        }
        bw.write(getNextPermutation()); 
        bw.flush();
        bw.close(); 
        br.close(); 
    }
    static String getNextPermutation() {
        int idx = N - 1; 
        while(idx > 0 && perm[idx] <= perm[idx-1]) idx--; 
        if(idx == 0) return "-1"; 
        int jdx = N - 1; 
        while(perm[idx - 1] >= perm[jdx]) jdx--; 
        swap(idx - 1, jdx); 
        int tail = N - 1; 
        while(idx < tail) {
            swap(idx++, tail--); 
        }
        return Arrays.toString(perm).replaceAll("[\\[\\],]", ""); 
    }
    static void swap(int i, int j) {
        int tmp = perm[i]; 
        perm[i] = perm[j]; 
        perm[j] = tmp; 
    }
}
