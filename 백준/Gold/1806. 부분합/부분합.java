import java.io.*;
import java.util.*;

public class Main {
    static int N, S; 
    static int[] nums; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        S = Integer.parseInt(st.nextToken()); 

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
        int count = Integer.MAX_VALUE; 

        int lt = 0, rt = 0; 
        long sum = 0; 

        while(lt < N && lt <= rt) {
            if(rt == N) {
                if(sum >= S) {
                    count = Math.min(count, rt - lt); 
                    sum -= nums[lt++]; 
                } else break; 
                continue; 
            }
            
            if(sum >= S) {
                count = Math.min(count, rt - lt); 
                sum -= nums[lt++]; 
            } else {
                sum += nums[rt]; 
                rt++; 
            }
        }

        if(count > 100_000) return 0; 
        return count; 
    }
}