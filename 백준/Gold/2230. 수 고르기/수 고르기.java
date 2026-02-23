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
        long min = Long.MAX_VALUE; 
        Arrays.sort(nums); 
        for(int i = 0; i < N; i++) {
            long target = nums[i];
            min = Math.min(min, search(target, i));  
        }
        return min;
    }

    private static long search(long target, int idx) {
        int lt = idx + 1, rt = N - 1; 
        long min = Long.MAX_VALUE; 
        while(lt <= rt) {
            int mid = (lt + rt) / 2; 
            long sum = Math.abs(nums[mid] - target); 

            if(sum >= M) {
                min = sum; 
                rt = mid - 1; 
            }
            else lt = mid + 1; 
        }
        return min; 
    }
}