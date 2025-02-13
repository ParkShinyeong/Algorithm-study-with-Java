
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine()); 
        int[] arr = new int[n]; 
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }
        List<Character> answer = solution(n, arr); 
        if(answer.isEmpty()) {
            bw.write("NO");
        }
        else {
            for(char c: answer) {
                bw.write(c + "\n"); 
            }
        }
		bw.flush();
		bw.close();
    }
    public static List<Character> solution(int n, int[] arr) {
        List<Character> ans = new ArrayList<>(); 
        Stack<Integer> st = new Stack<>(); 
        int cnt = 1; 
        for(int tmp: arr) { // 현재 숫자 
             while(cnt <= tmp) { // 스택이 비어있지 않을 때 
            	 st.add(cnt++); 
            	 ans.add('+'); 
             }
             if(!st.isEmpty() && st.peek() == tmp) {
            	 st.pop(); 
            	 ans.add('-'); 
             } else {
            	 return new ArrayList<Character>(); 
             }
        }
        return ans; 
    }
}