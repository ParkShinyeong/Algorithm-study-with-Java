import java.io.*;
import java.util.*;
public class Main{
	static int cnt = 0; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt(br.readLine()); 
		
		boolean[] col = new boolean[N]; 
		boolean[] right = new boolean[N*2 - 1]; // 오른쪽 아래로 향하는 대각선 
		boolean[] left = new boolean[N*2 - 1]; // 왼쪽 아래로 향하는 대각선 
		backtracking(N, 0, col, right, left); 
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void backtracking(int N, int r, boolean[] collum, boolean[] right, boolean[] left) {
		if(r == N) {
			cnt++; 
			return; 
		}
		
		for(int c = 0; c < N; c++) {
			if(collum[c] || left[c+r] || right[c - r + N - 1]) continue; // 이미 방문한 곳이라면 넘어감 
			
			collum[c] = true; 
			left[c+r] = true; 
			right[c - r + N - 1] = true; 
			backtracking(N, r + 1, collum, right, left);
			collum[c] = false; 
			left[c+r] = false; 
			right[c - r + N - 1] = false; 
		}
		
	}
}
