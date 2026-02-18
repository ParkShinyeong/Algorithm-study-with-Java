import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static long[] liquids; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); 

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        liquids = new long[N]; 
        for(int i = 0; i < N; i++) {
            liquids[i] = Long.parseLong(st.nextToken()); 
        }
        solution(); 

        br.close(); 
    }

    static void solution() {
        Arrays.sort(liquids); 
        int lt = 0, rt = N - 1; 
        long min = Integer.MAX_VALUE; 
        long a = 0, b = 0; 

        while(lt < rt) {
            long tmp = liquids[lt] + liquids[rt]; 
            if(min > Math.abs(tmp)) {
                min = Math.abs(tmp); 
                a = liquids[lt]; 
                b = liquids[rt]; 
            }
            if(tmp > 0) rt--; 
            else lt++; 
        }

        System.out.println(a + " " + b); 

    }
}