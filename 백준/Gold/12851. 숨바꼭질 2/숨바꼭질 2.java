import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        
        bw.write(solution(N, K)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static String solution(int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>(); 
        int[] times = new int[100_001]; 
        int[] count = new int[100_001];  
        Arrays.fill(times, -1); 
        times[K] = 0; 
        count[K] = 1; 
        queue.offer(K); 
        int tmpTime = 0; 

        while(!queue.isEmpty()) {
            int size = queue.size(); 
            tmpTime++; 
            for(int i = 0; i < size; i++) {
                int tmp = queue.poll(); 
                int nxt = 0; 
                if(tmp % 2 == 0) check(queue, times, count, tmp / 2, tmpTime, tmp);
                if(tmp - 1 >= 0) check(queue, times, count, tmp - 1, tmpTime, tmp);
                if(tmp + 1 <= 100_000) check(queue, times, count, tmp + 1, tmpTime, tmp);
            }
        }

        return times[N] + "\n" + count[N]; 
        
    }

    private static void check(Queue<Integer> queue, int[] times, int count[], int nxt, int tmpTime, int tmp) {
        if(times[nxt] < 0) {
            queue.offer(nxt);
            times[nxt] = tmpTime; 
            count[nxt] = count[tmp];
        } else if(times[nxt] == tmpTime) {
            count[nxt] += count[tmp];  
        }
    }
}