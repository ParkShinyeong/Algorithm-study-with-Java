import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[][] miro; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        miro = new int[N][M]; 

        for(int i = 0; i < N; i++) {
            String input = br.readLine(); 
            for(int j = 0; j < M; j++) {
                miro[i][j] = Integer.valueOf(input.charAt(j) - '0'); 
            }
        }
        // for(int i = 0; i < N; i++) {
        //         System.out.println(Arrays.toString(miro[i])); 
        //     }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int[] dirx = {0, 0, 1, -1}; 
        int[] diry = {1, -1, 0, 0};
        int INF = 1_000_000;  
        int[][] brokenWallCnt = new int[N][M]; 
        for(int i = 0; i < N; i++) {
            Arrays.fill(brokenWallCnt[i], INF); 
        }

        PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Position(0, 0, 0)); 
        brokenWallCnt[0][0] = 0;  

        while(!pq.isEmpty()) {
            Position tmp = pq.poll(); 
            if(tmp.cost > brokenWallCnt[tmp.x][tmp.y]) continue; 
            if(tmp.x == N - 1 && tmp.y == M - 1) break; 

            for(int d = 0; d < 4; d++) {
                int nx = tmp.x + dirx[d]; 
                int ny = tmp.y + diry[d]; 
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; 
    
                int cost = miro[nx][ny] == 1 ? 1 : 0; 
                if(brokenWallCnt[nx][ny] <= tmp.cost + cost) continue; 
                brokenWallCnt[nx][ny] = tmp.cost + cost; 
                pq.offer(new Position(nx, ny, tmp.cost + cost)); 
            }
        }


        return brokenWallCnt[N - 1][M - 1]; 
    }
}

class Position {
    int x, y, cost; 
    Position(int x, int y, int cost) {
        this.x = x; 
        this.y = y; 
        this.cost = cost; 
    }
}