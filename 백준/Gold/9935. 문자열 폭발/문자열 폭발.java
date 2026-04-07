import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); 
        String bombStr = br.readLine(); 

        bw.write(solution(str, bombStr)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static String solution(String str, String bombStr) {
        StringBuilder answer = new StringBuilder(); 
        
        for(int i = 0; i < str.length(); i++) {
            answer.append(str.charAt(i)); 
            int size = bombStr.length();
            if(answer.length() < size) continue; 

            boolean isSame = true; 
            for(int j = size - 1; j >= 0; j--) {
                if(bombStr.charAt(j) != answer.charAt(j + answer.length() - size)) {
                    isSame = false; 
                    break; 
                } 
            }
            if(!isSame) continue; 
            answer.delete(answer.length() - size, answer.length()); 
        }

        return answer.length() == 0 ? "FRULA" : answer.toString(); 
    }
}