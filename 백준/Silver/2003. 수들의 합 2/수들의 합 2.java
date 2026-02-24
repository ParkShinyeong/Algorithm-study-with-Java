import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static long M; 
    static int[] nums; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Long.parseLong(st.nextToken()); 

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

    private static long solution() {
        long cnt = 0; 

        int st = 0, ed = 0; 
        long sum = 0; 

        while(true) {
            if(sum >= M) {
                if(sum == M) cnt++; 
                sum -= nums[st++]; 
            } else if (ed == N) {
                break; 
            } else {
                sum += nums[ed++]; 
            }
        }

        return cnt; 
    }
}