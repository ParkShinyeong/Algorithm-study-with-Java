import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 

        if(N == 1) {
            bw.write("1"); 
            bw.flush(); 
            return; 
        } 

        int prev1 = 1, prev2 = 2; 
        
        for(int i = 3; i <= N; i++) {
            int n = (prev1 + prev2) % 10007; 
            prev1 = prev2; 
            prev2 = n; 
        }

        bw.write(String.valueOf(prev2)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}