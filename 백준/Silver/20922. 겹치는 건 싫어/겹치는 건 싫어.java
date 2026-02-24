import java.io.*;
import java.util.*;

public class Main {
    static int N, K; 
    static int[] nums; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        nums = new int[N]; 
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int[] count = new int[100_001]; 
        int st = 0, ed = 0; 
        int cnt = 0, max = 0; 

        while(ed < N) {
            
            while(st <= ed && count[nums[ed]] >= K) {
                count[nums[st++]]--; 
                cnt--; 
            }
            if(count[nums[ed]] < K) {
                count[nums[ed++]]++; 
                cnt++; 
            }
            max = Math.max(cnt, max); 
        }
        return max; 
    }
}