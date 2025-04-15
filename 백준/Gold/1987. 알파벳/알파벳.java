import java.io.*;
import java.util.*;

public class Main {
	static int R, C, max; 
	static int[] dirx = {0, 0, 1, -1}; 
	static int[] diry = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        R = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        max = 1; 
        char[][] board = new char[R][C]; 
        
        for(int i = 0; i < R; i++) {
        	String input = br.readLine(); 
        	for(int j = 0; j < C; j++) {
        		board[i][j] = input.charAt(j); 
        	}
        }
        
        solution(board); 
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
	}
	
	static void solution(char[][] board) {
		boolean[] visit = new boolean[26]; 
		visit[board[0][0] - 65] = true; 
		dfs(board, 0, 0, visit, 1); 
	}
	
	static void dfs(char[][] board, int x, int y, boolean[] visit, int cnt) {
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dirx[d]; 
			int ny = y + diry[d]; 
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue; 
			if(visit[board[nx][ny] - 65]) {
				max = Math.max(max, cnt); 
				continue; 
			}
			visit[board[nx][ny] - 65] = true; 
			dfs(board, nx, ny, visit, cnt + 1); 
			visit[board[nx][ny] - 65] = false; 
		}
	}
}
