import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] dirx = {0, 0, -1, 1}; 
	static int[] diry = {1, -1, 0, 0};
	static int N, M; 
	static int[][] board; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st; 
        int T = Integer.parseInt(br.readLine()); 
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	M = Integer.parseInt(st.nextToken()); 
        	N = Integer.parseInt(st.nextToken()); 
        	int K = Integer.parseInt(st.nextToken()); 
        	board = new int[M][N]; 
        	for(int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken()); 
        		int y = Integer.parseInt(st.nextToken());
        		
        		board[x][y] = 1; 
        	}
        	int ans = solution(); 
        	bw.write(ans + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static int solution() {
		int cnt = 0; 
		boolean[][] visit = new boolean[M][N]; 
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					visit[i][j] = true; 
					dfs(visit, i, j); 
					cnt++; 
				}
			}
		}
		return cnt; 
	}
	
	static void dfs(boolean[][] visit, int x, int y) {
		if(board[x][y] != 1) return; 
		visit[x][y] = true; 
		board[x][y] += 1; 
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dirx[i]; 
			int ny = y + diry[i]; 
			
			if(nx < 0 || nx >= M || ny < 0 || ny >= N || visit[nx][ny]) {
				continue; 
			}
			dfs(visit, nx, ny); 
		}
	}
}
