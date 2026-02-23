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

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        Arrays.sort(arr); 
        int cnt = 0; 
        for(int i = 0; i < N; i++) {
            long target = arr[i]; 
            if(isGoodNumber(target, i)) cnt++; 
        }
        return cnt; 
    }
    private static boolean isGoodNumber(long target, int idx) {
        int lt = 0, rt = N - 1; 
        while(lt < rt) {
            if(lt == idx) {
                lt++; 
                continue; 
            } 
            if(rt == idx) {
                rt--; 
                continue; 
            }

            long sum = arr[lt] + arr[rt]; 
            if(sum == target) return true; 
            else if (sum > target) rt--; 
            else lt++; 
        }
        return false; 
    }
}