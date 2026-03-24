import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M; 
    static Shark[][] board; 
    static Queue<Shark> sharks; 
    static int[] dirx = {0, -1, 1, 0, 0}; 
    static int[] diry = {0, 0, 0, 1, -1}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        R = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        board = new Shark[R + 1][C + 1]; 
        sharks = new ArrayDeque<>(); 
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int r = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            int s = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken()); 
            int z = Integer.parseInt(st.nextToken()); 
            Shark shark = new Shark(r, c, s, d, z); 
            sharks.offer(shark); 
            board[r][c] = shark; // 상어가 있음
        }

        bw.write(solution() + ""); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int total = 0; 
        for(int k = 1; k <= C; k++) {
            total += catchShark(k); 
            moveEveryShark(); 
        }
        return total; 
    }

    private static int catchShark(int c) {
        for(int i = 1; i <= R; i++) {
            if(board[i][c] != null) {
                board[i][c].isLive= false; 
                int size = board[i][c].size; 
                board[i][c] = null; 
                return size; 
            }
        }
        return 0; 
    }

    private static void moveEveryShark() {
        for(int i = 0; i <= R; i++) {
            Arrays.fill(board[i], null); 
        }

        int size = sharks.size(); 

        for(int i = 0; i < size; i++) {
            Shark tmp = sharks.poll(); 
    
            if(!tmp.isLive) continue; // 죽은 상어는 넘어간다. 
            moveShark(tmp); 
            if(board[tmp.x][tmp.y] != null) {
                if(board[tmp.x][tmp.y].size > tmp.size) {
                    tmp.isLive = false; 
                    continue; 
                }
                else board[tmp.x][tmp.y].isLive = false; 
            }
            board[tmp.x][tmp.y] = tmp; 
            sharks.offer(tmp); 
        }
    }

    private static void moveShark(Shark shark) {
        int len = shark.speed; 
        int rRange = (R - 1) * 2; 
        int cRange = (C - 1) * 2; 

        if(shark.dir >= 3) len %= cRange; 
        else len %= rRange; 
        
        while(len != 0) {
            len--; 
            int nx = shark.x + dirx[shark.dir]; 
            int ny = shark.y + diry[shark.dir]; 

            if(nx < 1 || ny < 1 || nx > R || ny > C) {
                shark.changeDirection(); 
                nx = shark.x + dirx[shark.dir]; 
                ny = shark.y + diry[shark.dir]; 
            }
            shark.x = nx; 
            shark.y = ny; 
        }
    }
}

class Shark {
    int x, y, speed, dir, size; 
    boolean isLive; 
    Shark(int x, int y, int s, int d, int size) {
        this.x = x; 
        this.y = y; 
        this.speed = s; 
        this.dir = d; 
        this.size = size; 
        isLive = true; 
    }

    void changeDirection() {
        if(dir == 1) dir = 2; 
        else if (dir == 2) dir = 1; 
        else if (dir == 3) dir = 4; 
        else if (dir == 4) dir = 3;    
    }
}