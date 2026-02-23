import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M;  
    static long[] nums; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Long.parseLong(st.nextToken()); 
        nums = new long[N]; 
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine()); 
        }
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static long solution() {
        Arrays.sort(nums); 
        long min = Long.MAX_VALUE; 
        int lt = 0, rt = 0; 

        while(rt < N && lt <= rt) {
            long sum = nums[rt] - nums[lt]; 
            if(sum >= M) {
                min = Math.min(min, sum); 
                lt++; 
            }
            else rt++; 
        }
        return min;
    }
}