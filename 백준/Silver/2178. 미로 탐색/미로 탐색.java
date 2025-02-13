import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
        	 String str = br.readLine();
             for (int j = 0; j < m; j++) {
                 board[i][j] = str.charAt(j) - '0';
             }
        }
        int answer = solution(n, m, board);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int solution(int n, int m, int[][] board) {
        int[][] visit = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        visit[0][0] = 1; 
        q.offer(new int[] { 0, 0 });
	    int[] dx = {0, 0, 1, -1}; 
	    int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) { 
        	int[] pos = q.poll();
        	int x = pos[0];
        	int y = pos[1];
        	if(x == n-1 && y == m-1) {
                return visit[x][y]; 
            }
        	for (int i = 0; i < 4; i++) {
        		int nxtX = x + dx[i];
        		int nxtY = y + dy[i];
        		if (nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m) continue; // 범위 벗어나면 무시 
        		if (visit[nxtX][nxtY] == 0 && board[nxtX][nxtY] == 1) {
        			visit[nxtX][nxtY] = visit[x][y] + 1;
        			q.offer(new int[] { nxtX, nxtY });
        		}
        	}	
        }
        return -1; 
    }
}