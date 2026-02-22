import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static long[][] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        arr = new long[4][N]; 

        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < 4; j++) {
                arr[j][i] = Long.parseLong(st.nextToken()); 
            }
        }

        long[] sum1 = new long[N * N]; 
        long[] sum2 = new long[N * N]; 
        int idx = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sum1[idx] = arr[0][i] + arr[1][j]; 
                sum2[idx] = arr[2][i] + arr[3][j]; 
                idx++; 
            }
        }
        long cnt = 0; 
        Arrays.sort(sum1); 
        Arrays.sort(sum2); 
        
        long prev = Long.MIN_VALUE;
        long prevCnt = 0;  
        for(long n: sum1) {
            if(prev != n) {
                prevCnt = (upperBound(sum2, -n) - lowerBound(sum2, -n)); 
                prev = n; 
            } 
            cnt += prevCnt; 
        }

        bw.write(cnt + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int lowerBound (long[] nums, long n) {
        int lt = 0, rt = nums.length; 
        while(lt < rt) {
            int mid = (lt + rt) / 2; 
            if(nums[mid] >= n) {
                rt = mid; 
            } else lt = mid + 1; 
        }
        return lt; 
    }

    private static int upperBound (long[] nums, long n) {
        int lt = 0, rt = nums.length; 
        while(lt < rt) {
            int mid = (lt + rt) / 2; 
            if(nums[mid] > n) {
                rt = mid; 
            } else lt = mid + 1; 
        }
        return lt; 
    }

}