import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[] nums; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); 
        nums = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
        }
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static long solution() {
        int st = 0, ed = 0; 
        boolean[] isVisited = new boolean[100_001]; 
        long cnt = 0; 

        while(true) {
            if(isVisited[nums[ed]]) {
                while(nums[st] != nums[ed]) {
                    isVisited[nums[st++]] = false; 
                }
                isVisited[nums[st++]] = false; 
            } else if (ed == N - 1) {
                cnt += ed - st + 1; 
                break; 
            } else {
                isVisited[nums[ed++]] = true;  
                cnt += ed - st; 
            }
        }
        return cnt; 
    }
}