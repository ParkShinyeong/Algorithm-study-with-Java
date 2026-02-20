import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static long[] nums; 
    static long min, num1, num2, num3; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        nums = new long[N]; 

        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken()); 
        }

        min = Long.MAX_VALUE; 
        Arrays.sort(nums); 

        StringBuilder sb = new StringBuilder(); 
        solution(); 
        sb.append(num1).append(" ").append(num2).append(" ").append(num3); 
        bw.write(sb.toString()); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    private static void solution() {
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                search(nums[i], nums[j], j + 1); 
            }
        }

    }
    private static void search(long n1, long n2, int start) {
        int lt = start, rt = N - 1; 
        while(lt <= rt) {
            int mid = (lt + rt) / 2; 
            long sum = nums[mid] + n1 + n2; 
            if(min > Math.abs(sum)) {
                min = Math.abs(sum); 
                num1 = n1; 
                num2 = n2; 
                num3 = nums[mid]; 
            }
            if(sum > 0) rt = mid - 1; 
            else lt = mid + 1; 
        }
    }
}