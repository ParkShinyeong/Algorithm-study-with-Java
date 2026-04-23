 import java.io.*;
import java.util.*;

public class Main {
    static final char A = 'A', B = 'B'; 
    static String S, T; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine(); 
        T = br.readLine(); 

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() { 
        Queue<String> queue = new ArrayDeque<>(); 
        queue.offer(T); 
        int answer = 0; 

        while(!queue.isEmpty()) {
            String tmp = queue.poll(); 
            char last = tmp.charAt(tmp.length() - 1); 
            char first = tmp.charAt(0); 
            if(tmp.length() == S.length()) {
                if(tmp.equals(S)) answer = 1; 
                continue; 
            }

            if(last == A) {
                String str = tmp.substring(0, tmp.length() - 1); 
                queue.offer(str); 
            } 
            if(first == B) {
                String str = tmp.substring(1, tmp.length()); 
                str = new StringBuilder(str).reverse().toString(); 
                queue.offer(str); 
            }
        }
        return answer;    
    }
}