import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c; 
    static int[] sushis; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        d = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 
        c = Integer.parseInt(st.nextToken()); 

        sushis = new int[N]; 

        for(int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine()); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int st = 0, ed = k; 
        int cnt = 0; 
        int maxCnt = 0; 
        int[] isSameSushi = new int[d + 1]; 

        for(int i = st; i < ed; i++) {
            if(isSameSushi[sushis[i]] == 0) {
                cnt++; 
            }
            isSameSushi[sushis[i]]++; 
        }

        for(st = 0; st < N; st++) {
            maxCnt = Math.max(cnt, maxCnt); 

            if(isSameSushi[c] == 0) {
                maxCnt = Math.max(cnt + 1, maxCnt); 
            }
            
            isSameSushi[sushis[st]]--; 
            if(isSameSushi[sushis[st]] == 0) cnt--; 

            if(isSameSushi[sushis[ed]] == 0) cnt++; 
            isSameSushi[sushis[ed]]++; 
            ed = (ed + 1) % N; 
        }
        return maxCnt; 
    }
}