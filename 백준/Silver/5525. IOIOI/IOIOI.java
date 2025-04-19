import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine()); 
		String str = br.readLine(); 
		String p = makePn(N);
		int answer = solution(N, M, str, p); 
		bw.write(answer + "");
		bw.flush(); 
		bw.close(); 
		br.close(); 
	}
	
	static int solution(int n, int m, String str, String p) {
		int cnt = 0; 
		
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < n*2; i++) {
			sb.append(str.charAt(i)); 
		}
		
		for(int rt = n*2; rt < m; rt++) {
			sb.append(str.charAt(rt)); 
			if(sb.toString().equals(p)) {
				cnt++; 
			}
			sb.deleteCharAt(0); 
		}
		
		return cnt; 
	}
	
	static String makePn(int n) {
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < (n*2 + 1); i++) {
			if(i % 2 == 0) {
				sb.append('I'); 
			} else {
				sb.append('O'); 
			}
		}
		
		return sb.toString(); 
	}
}
