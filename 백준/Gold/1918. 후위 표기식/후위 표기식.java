import java.io.*;
import java.util.*;
public class Main {
    static HashMap<Character, Integer> priority = new HashMap<>(); 
    static {
        priority.put('(', 0);
        priority.put('+', 1); 
        priority.put('-', 1); 
        priority.put('*', 2); 
        priority.put('/', 2); 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine(); 
        bw.write(solution(str));
        bw.flush();
        bw.close();
        br.close();
    }
    static String solution(String str) {
        Stack<Character> st = new Stack<>(); 
        StringBuilder sb = new StringBuilder(); 
        for(char c: str.toCharArray()) {
            if(Character.isAlphabetic(c)) { 
                sb.append(c);
                continue; 
            }
            if(c == '(') {
                st.add(c); 
            } else if (c == ')') {
                char oper; 
                while((oper = st.pop()) != '(') {
                    sb.append(oper); 
                }
            } else {
                int tmp = priority.get(c); 
                while(!st.isEmpty() && tmp <= priority.get(st.peek())) {
                    sb.append(st.pop()); 
                }
                st.add(c); 
            }
        }
        while(!st.isEmpty()) {
            sb.append(st.pop()); 
        }
        return sb.toString(); 

    }
}