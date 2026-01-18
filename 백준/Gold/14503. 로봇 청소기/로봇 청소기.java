import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[][] room; 
    static int[] dirx = {-1, 0, 1, 0}; 
    static int[] diry = {0, 1, 0, -1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());  

        st = new StringTokenizer(br.readLine()); 
        int r = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 

        room = new int[N][M]; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        moveRobotVacuum(new Position(r, c, d));
        bw.write(String.valueOf(countCleaning()));
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void moveRobotVacuum(Position position) {
        while(true) {
            if(room[position.r][position.c] == 0) {
                room[position.r][position.c] = -1; 
            }

            boolean isMessy = false; 
            for(int i = 0; i < 4; i++) {
                position.rotateDirectionCounterClockWise(); 
                int nr = position.r + dirx[position.d]; 
                int nc = position.c + diry[position.d]; 
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] == 1) continue; 
                if(room[nr][nc] == 0) {
                    position.setPosition(nr, nc);
                    isMessy = true; 
                    break; 
                } 
            }

            if(!isMessy) { 
                int nr = position.r - dirx[position.d]; 
                int nc = position.c - diry[position.d]; 
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] == 1) break; // 후진할 수 없다면 작동을 멈춘다. 
                position.setPosition(nr, nc); 
            }
        }
    }

    static int countCleaning() {
        int cnt = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(room[i][j] == -1) cnt++; 
            }
        }

        return cnt; 
    }
}

class Position {
    int r, c, d; 
    
    Position(int r, int c, int d) {
        this.r = r; 
        this.c = c; 
        this.d = d; 
    }

    void setPosition(int r, int c) {
        this.r = r; 
        this.c = c; 
    }

    void rotateDirectionCounterClockWise() {
        d = (d - 1 + 4) % 4; 
    }
}