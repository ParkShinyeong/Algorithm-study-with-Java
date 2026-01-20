import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        long[] arr = new long[N];
        int maxCount = 0; 
        long max = 0; 

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine()); 
        }

        Arrays.sort(arr); 
        int prevIdx = 0; 
        for(int i = 0; i <= N; i++) {
            if(i == N || arr[prevIdx] != arr[i]) {
                if(maxCount < i - prevIdx) {
                    maxCount = i - prevIdx; 
                    max = arr[prevIdx]; 
                }
                prevIdx = i; 
            }
        }

        bw.write(max + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}