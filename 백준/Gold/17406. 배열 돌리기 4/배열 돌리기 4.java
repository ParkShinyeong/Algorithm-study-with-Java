import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K; 
	static int[][] board; 
	static int[][] rotate; 
	static int min = Integer.MAX_VALUE; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		board = new int[N][M]; 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		rotate = new int[K][3]; 
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()); 
			rotate[i][0] = Integer.parseInt(st.nextToken()) - 1; // r
			rotate[i][1] = Integer.parseInt(st.nextToken()) - 1; // c
			rotate[i][2] = Integer.parseInt(st.nextToken()); // s
		}
		ArrayList<Integer> result = new ArrayList<>(); 
		boolean[] visit = new boolean[K]; 
		getSequence(result, 0, visit); 
		
		bw.write(min + "");
		bw.flush(); 
		bw.close(); 
		br.close(); 
	}
	static void getSequence(ArrayList<Integer> result, int depth, boolean[] visit) {
		if(depth == K) {
            // 배열 복사 
            int[][] copyBoard = new int[N][M];
            for(int i = 0; i < N; i++) {
            	System.arraycopy(board[i], 0, copyBoard[i], 0, M);
            }

			for(int num: result) {
				copyBoard = rotateBoard(rotate[num][0], rotate[num][1], rotate[num][2], copyBoard);
			}
			getMin(copyBoard); 
			return; 
		}
		
		for(int i = 0; i < K; i++) {
			if(visit[i]) continue; 
			visit[i] = true; 
			result.add(i); 
			getSequence(result, depth + 1, visit); 
			result.remove(result.size() - 1); 
			visit[i] = false; 
		}
	}
	
	static void getMin(int[][] board) {
		for(int i = 0; i < N; i++) {
			int sum = 0; 
			for(int j = 0; j < M; j++) {
				sum += board[i][j]; 
			}
			min = Math.min(min, sum);
		}
	}

	
	static int[][] rotateBoard(int r, int c, int s, int[][] copyBoard) {
		int[] dirx = {0, 1, 0, -1};
		int[] diry = {1, 0, -1, 0}; 
		for(int i = 1; i <= s; i++) {
			int dir = 0; 
			int tmpx = r - i, tmpy = c - i;
            int prev = copyBoard[tmpx][tmpy];  
			while(dir < 4) {
                int nx = tmpx + dirx[dir]; 
				int ny = tmpy + diry[dir]; 
				
				if(nx < r-i || nx > r + i || ny < c-i || ny > c + i || nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    dir++; 
					continue; 
				}
				int tmp = copyBoard[nx][ny]; 
				copyBoard[nx][ny] = prev; 
				prev = tmp;
				tmpx = nx; 
				tmpy = ny; 
				
			}
		}
		return copyBoard; 
	}
}
