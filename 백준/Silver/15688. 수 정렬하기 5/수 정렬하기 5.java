import java.io.*;
// Counting sort 
public class Main {
    static final int total = 2_000_001; 
    static final int half = 1_000_000; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N];
        int[] count = new int[2_000_001]; 
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine()); 
            count[input + half]++; 
        }
        int arrIdx = 0; 
        for(int i = 0; i < total; i++) {
            if(arrIdx == N) break; 
            while(count[i] > 0) {
                count[i]--; 
                arr[arrIdx++] = i - half; 
            }
        }
        for(int i : arr) {
            bw.write(i + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}
