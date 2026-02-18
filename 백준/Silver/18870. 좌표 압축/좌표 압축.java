import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        int[] nums = new int[N]; 
        int[] sorted = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
            sorted[i] = nums[i]; 
        }
        Arrays.sort(sorted); 
        int j = 0; 
        for(int i = 1; i < N; i++) {
            if(sorted[j] != sorted[i]) {
                sorted[++j] = sorted[i]; 
            }
        }
        for(int n : nums) {
            bw.write(Arrays.binarySearch(sorted, 0, j + 1, n) + " "); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}