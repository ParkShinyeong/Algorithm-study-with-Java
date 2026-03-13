import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R; 
    static int[][] lands; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken()); 

        lands = new int[N][N]; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                lands[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int count = 0; 

        while(true) {
            boolean flag = bfs(); 
            if(!flag) break; 
            count++; 
        }
        return count; 
    }

    private static boolean bfs() {
        int[] dirx = {0, 0, 1, -1}; 
        int[] diry = {1, -1, 0, 0}; 
        boolean[][] visited = new boolean[N][N]; 
        boolean flag = false; 
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) continue; 

                Position tmpLand = new Position(i, j); 
                visited[i][j] = true; 
                int total = lands[i][j]; 
                ArrayList<Position> sameLand = new ArrayList<>(); 
                sameLand.add(tmpLand);

                Queue<Position> queue = new ArrayDeque<>(); 
                queue.offer(tmpLand); 

                while(!queue.isEmpty()) {
                    Position tmp = queue.poll(); 
                    
                    for(int d = 0; d < 4; d++) {
                        int nx = tmp.x + dirx[d]; 
                        int ny = tmp.y + diry[d]; 

                        if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue; 
                        int calc = Math.abs(lands[tmp.x][tmp.y] - lands[nx][ny]); 
                        if(L <= calc && calc <= R) {
                            visited[nx][ny] = true; 
                            Position nxt = new Position(nx, ny); 
                            queue.offer(nxt); 
                            sameLand.add(nxt);
                            total += lands[nx][ny]; 
                            flag = true; 
                        }
                    }
                }

                int cnt = sameLand.size(); 
                int newPopulation = total / cnt; 
                for(Position pos: sameLand) {
                    lands[pos.x][pos.y] = newPopulation; 
                }
            }
        }
        return flag; 
    }
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}