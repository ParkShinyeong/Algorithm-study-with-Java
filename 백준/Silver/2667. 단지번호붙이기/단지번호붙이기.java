import java.io.*;
import java.util.*;
public class Main {
	static int N; 
	static int[][] board; 
	static int[] dirx = {1, -1, 0, 0}; 
	static int[] diry = {0, 0, 1, -1}; 
	static int cnt; // 단지 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        N = Integer.parseInt(br.readLine()); 
        board = new int[N][N]; 
        
        for(int i = 0; i < N; i++) {
        	String input = br.readLine(); 
        	for(int j = 0; j < N; j++) {
        		board[i][j] = Integer.valueOf(input.charAt(j) - '0'); 
        	}
        }
        cnt = 1; 
        ArrayList<Integer> aptCntArr = new ArrayList<Integer>(); 
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(board[i][j] == 1) {
        			aptCntArr.add(bfs(i, j)); 
        			cnt++; 
        		}
        	}
        }
        Collections.sort(aptCntArr);
        bw.write(cnt - 1 + "\n");
        for(int apt: aptCntArr) {
        	bw.write(apt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
    
	static int bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>(); 
		q.offer(new int[] {x, y}); 
		board[x][y] += cnt; 
		int aptCnt = 0; 
		
		while(!q.isEmpty()) {
			aptCnt++; 
			int[] tmp = q.poll();
			int tmpx = tmp[0]; 
			int tmpy = tmp[1]; 
			for(int d = 0; d < 4; d++) {
				int nx = tmpx + dirx[d]; 
				int ny = tmpy + diry[d]; 
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; 
				if(board[nx][ny] != 1) continue;   
				
				board[nx][ny] += cnt;
				q.offer(new int[] { nx, ny }); 
			}
		}
		return aptCnt; 
	}
}
