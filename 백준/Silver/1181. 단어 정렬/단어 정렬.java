import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine()); 

        String[] strs = new String[N]; 

        for(int i = 0; i < N; i++) {
            strs[i] = br.readLine(); 
        }

        Arrays.sort(strs, (a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length(); 
            return a.compareTo(b); 
        }); 

        String prev = ""; 
        for(String str: strs) {
            if(prev.equals(str)) continue; 
            bw.write(str + "\n"); 
            prev = str; 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}