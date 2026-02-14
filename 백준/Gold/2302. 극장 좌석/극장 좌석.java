import java.io.*;
import java.util.*;

public class Main {
    static final int n = 40; 
    static int[] fibo = new int[n + 1]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 
        boolean[] isVip = new boolean[N + 1]; 

        for(int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine()); 
            isVip[vip] = true; 
        }

        int answer = solution(N, isVip);
        
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution(int N, boolean[] isVip) {
        int cnt = 0; 
        int answer = 1; 
        for(int i = 1; i <= N; i++) {
            if(isVip[i]) {
                 answer *= calculateFibo(cnt); 
                 cnt = 0;
            }
            else cnt++; 
        }

        if(!isVip[N]) answer *= calculateFibo(cnt); 
        return answer; 
    }

    private static int calculateFibo(int count) {
        if(count <= 1) return 1; 
        if(fibo[count] > 0) return fibo[count]; 
        return fibo[count] = calculateFibo(count - 1) + calculateFibo(count - 2);         
    }
}