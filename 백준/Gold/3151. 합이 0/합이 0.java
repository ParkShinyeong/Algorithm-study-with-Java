import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static long[] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); 
        arr = new long[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken()); 
        }

        Arrays.sort(arr); 
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static long solution() {
        long cnt = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                long sum = arr[i] + arr[j]; 
                int cntN = upperBound(-sum, j + 1) - lowerBound(-sum, j + 1); 
                cnt += cntN; 
            }
        }
        return cnt; 
    }

    private static int lowerBound(long n, int start) {
        int lt = start, rt = N; 
        while(lt < rt) {
            int mid = (lt + rt) / 2; 
            if(n <= arr[mid]) {
                rt = mid; 
            } else {
                lt = mid + 1; 
            }
        }
        return lt; 
    }

    private static int upperBound(long n, int start) {
        int lt = start, rt = N; 
        while(lt < rt) {
            int mid = (lt + rt) / 2; 
            if(n < arr[mid]) {
                rt = mid; 
            } else {
                lt = mid + 1; 
            }
        }
        return lt; 
    }
}