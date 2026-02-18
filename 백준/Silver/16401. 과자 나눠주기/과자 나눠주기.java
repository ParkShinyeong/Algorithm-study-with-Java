import java.io.*;
import java.util.*;
public class Main {
    static int N, M; 
    static int[] snacks; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        snacks = new int[N]; 
        st = new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken()); 
        }

        bw.write(String.valueOf(solve())); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    static int solve() {
        Arrays.sort(snacks); 
        int st = 1; 
        int ed = snacks[N - 1]; 

        while(st <= ed) {
            int mid = (st + ed) / 2; 
            int cnt = getSnackCount(mid); 
            if(cnt < M) { // 과자 개수가 작은 경우 
                ed = mid - 1; 
            } else {
                st = mid + 1; 
            }
        }
        return ed; 
    }
    static int getSnackCount(int len) {
        int cnt = 0; 
        for(int i = 0; i < N; i++) {
            cnt += snacks[i] / len; 
        }
        return cnt; 
    }
}