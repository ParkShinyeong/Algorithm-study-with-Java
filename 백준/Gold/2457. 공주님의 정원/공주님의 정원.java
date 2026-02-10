import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        Flower[] flowers = new Flower[N]; 
        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int sm = Integer.parseInt(st.nextToken()); 
            int sd = Integer.parseInt(st.nextToken()); 
            int em = Integer.parseInt(st.nextToken()); 
            int ed = Integer.parseInt(st.nextToken()); 
            flowers[i] = new Flower(sm, sd, em, ed); 
        }

        Arrays.sort(flowers, (a, b) -> {
            if(a.start == b.start) {
                return b.end - a.end; 
            } 
            return a.start - b.start; 
        }); 

        int cnt = 0; 
        int tmp = 301; 
        int idx = 0;  
        int maxEnd = 0;
        while(tmp <= 1130) {
            boolean found = false; 
            while(idx < N && flowers[idx].start <= tmp) {
                if(flowers[idx].end > maxEnd) {
                    maxEnd = flowers[idx].end; 
                    found = true; 
                }
                idx++; 
            }
            if(found) {
                tmp = maxEnd; 
                cnt++; 
                if(tmp > 1130) {
                    break; 
                }
            } else {
                break; 
            }
        }
        if(tmp <= 1130) cnt = 0;
        bw.write(String.valueOf(cnt)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}

class Flower {
    int start, end; 
    Flower(int sm, int sd, int em, int ed) {
       start = sm * 100 + sd; 
       end = em * 100 + ed; 
    }    
}