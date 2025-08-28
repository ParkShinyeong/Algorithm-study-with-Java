import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine()); 
		for(int t = 0; t < test; t++) {
			String input = br.readLine(); 
			bw.write(solution(input));
			bw.write("\n");
		}
		bw.flush(); 
		bw.close();
		br.close();
	}
	public static String solution(String input) {
		ArrayDeque<Character> prevCursor = new ArrayDeque<>(); 
		ArrayDeque<Character> nextCursor = new ArrayDeque<>(); 
		for(char c : input.toCharArray()) {
			if(c == '-') {
				if (!prevCursor.isEmpty()) {
					prevCursor.pollLast(); 
				}
			} else if (c == '<') {
				if(prevCursor.isEmpty()) continue; 
				char last = prevCursor.pollLast(); 
				nextCursor.addFirst(last); 
			} else if (c == '>') {
				if(nextCursor.isEmpty()) continue; 
				char first = nextCursor.pollFirst(); 
				prevCursor.add(first); 
			} else {
				prevCursor.add(c); 
			}
		}
		StringBuilder str = new StringBuilder(); 
		while(!prevCursor.isEmpty()) {
			str.append(prevCursor.pollFirst()); 
		}
		while(!nextCursor.isEmpty()) {
			str.append(nextCursor.pollFirst()); 
		}
		return str.toString(); 
	}
}
