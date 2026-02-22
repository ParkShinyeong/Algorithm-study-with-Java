import java.io.*;
import java.util.*;

public class Main {
    static int N, C; 
    static int[] homes; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        
        homes = new int[N]; 

        for(int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(homes); 
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int lt = 1, rt = homes[N - 1]; 

        while(lt <= rt) {
            int mid = (lt + rt) / 2; 
            int count = countRouter(mid); 

            if(count < C) {
                rt = mid - 1; 
            } else {
                lt = mid + 1; 
            }
        }
        return rt; 
    }

    private static int countRouter(int len) {  
        int cnt = 1, pos = homes[0] + len; 
        for(int i = 0; i < N; i++) {
            if(homes[i] >= pos) {
                cnt++; 
                pos = homes[i] + len; 
            }
        }
        return cnt; 
    }
}