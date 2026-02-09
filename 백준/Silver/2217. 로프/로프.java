import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }
        Arrays.sort(arr);
        int cnt = N; 
        int max = 0; 
        for(int i = 0; i < N; i++) {
            max = Math.max(max, cnt-- * arr[i]); 
        }
        bw.write(max + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}