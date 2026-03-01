import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, max; 
    static int[] restareas; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 

        restareas = new int[N + 2]; 
        restareas[0] = 0; 
        restareas[N + 1] = L; 

        st = new StringTokenizer(br.readLine()); 

        for(int i = 1; i <= N; i++) {
            restareas[i] = Integer.parseInt(st.nextToken()); 
        }
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        Arrays.sort(restareas); 

        int st = 1, ed = L - 1; 

        while(st <= ed) {
            int mid = (st + ed) / 2; 
            int cnt = setRestArea(mid); 

            if(cnt <= M) {
                ed = mid - 1; 
            } else {
                st = mid + 1; 
            } 
        }
        return st; 
    }

    private static int setRestArea(int len) {
        int cnt = 0; 
        for(int i = 0; i <= N; i++) {
            int tmpLen = restareas[i + 1] - restareas[i]; 
            cnt += (tmpLen - 1) / len; 
        }
        return cnt; 
    }
}