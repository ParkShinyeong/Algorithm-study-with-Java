import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        String[] pocketmons = new String[N + 1]; 
        Map<String, Integer> pocketmonNumbers = new HashMap<>(); 

        for(int i = 1; i <= N; i++) {
            String input = br.readLine(); 
            pocketmons[i] = input; 
            pocketmonNumbers.put(input, i); 
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine(); 
            char c = input.charAt(0); 
            if(Character.isDigit(c)) {
                int idx = Integer.parseInt(input); 
                bw.write(pocketmons[idx] + "\n"); 
            } else {
                bw.write(pocketmonNumbers.get(input) + "\n"); 
            }
        }

        bw.flush();     
        bw.close(); 
        br.close(); 
    }
}