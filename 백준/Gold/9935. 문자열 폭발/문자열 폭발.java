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
        
        Stack<Character> stack = new Stack<>(); 
        
        for(int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i)); 
            int size = bombStr.length();
            if(stack.size() < size) continue; 

            boolean isSame = true; 
            for(int j = size - 1; j >= 0; j--) {
                if(bombStr.charAt(j) != stack.get(j + stack.size() - size)) {
                    isSame = false; 
                    break; 
                } 
            }
            if(!isSame) continue; 
            
            for(int j = 0; j < size; j++) {
                stack.pop(); 
            }
        }

        if(stack.isEmpty()) return "FRULA";
        StringBuilder answer = new StringBuilder(); 
        for(int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i)); 
        }
        return answer.toString(); 
    }
}