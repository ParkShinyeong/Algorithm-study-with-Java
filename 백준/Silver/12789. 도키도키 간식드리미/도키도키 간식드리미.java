import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        Queue<Integer> q = new ArrayDeque<>(); 
        int[] arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
        	int input = Integer.parseInt(st.nextToken()); 
        	q.offer(input); 
        	arr[i] = input; 
        }
       Arrays.sort(arr);
       String answer = solution(N, q, arr) ? "Nice" : "Sad"; 
       bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static boolean solution(int N, Queue<Integer> q, int[] arr) {
		Stack<Integer> st = new Stack<>(); 
		int priority = 0; 
		while(!q.isEmpty()) {
			int first = q.poll(); 
			if(first == arr[priority]) {
				priority++; 
				while(!st.isEmpty() && st.peek() == arr[priority]) {
					st.pop(); 
					priority++; 
				}
			} else {
				st.add(first); 					
			}
		}
		if(priority == N) return true; 
		else return false; 
	}
}
