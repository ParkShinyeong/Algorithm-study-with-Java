import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static char[][] board; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        board = new char[N][M]; 

        Position red = null; 
        Position blue = null; 

        for(int i = 0; i < N; i++) {
            String input = br.readLine(); 
            for(int j = 0; j < M; j++) {
                char tmp = input.charAt(j); 
                board[i][j] = tmp; 
                if(tmp == 'R') {
                    red = new Position(i, j); 
                    board[i][j] = '.';
                }
                else if(tmp == 'B') {
                    blue = new Position(i, j); 
                    board[i][j] = '.'; 
                }
            }
        }

        bw.write(String.valueOf(bfs(red, blue))); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int bfs(Position red, Position blue) {
        boolean[][][][] isVisited = new boolean[N][M][N][M]; 
        isVisited[red.x][red.y][blue.x][blue.y] = true; 

        Queue<State> q = new ArrayDeque<>(); 
        q.offer(new State(red, blue, 0)); 

        while(!q.isEmpty()) {
            State curr = q.poll(); 
            
            if(curr.count >= 10) continue; 
            Position nxtRed; 
            Position nxtBlue; 
            
            for(int d = 0; d < 4; d++) {
                nxtBlue = moveBall(curr.blue, d); 
                nxtRed = moveBall(curr.red, d); 

                if(board[nxtBlue.x][nxtBlue.y] == 'O') continue; 
                if(board[nxtRed.x][nxtRed.y] == 'O') {
                    return curr.count + 1; 
                }

                if(nxtRed.equals(nxtBlue)) {
                    if(isRedFirst(curr.red, curr.blue, d)) {
                        nxtBlue.x -= dirx[d]; 
                        nxtBlue.y -= diry[d]; 
                    } else {
                        nxtRed.x -= dirx[d]; 
                        nxtRed.y -= diry[d]; 
                    }
                }

                
                if(isVisited[nxtRed.x][nxtRed.y][nxtBlue.x][nxtBlue.y]) continue; 
                q.offer(new State(nxtRed, nxtBlue, curr.count + 1)); 
                isVisited[nxtRed.x][nxtRed.y][nxtBlue.x][nxtBlue.y] = true; 
            }
        }
        return -1; 

    }
 

    private static boolean isRedFirst(Position red, Position blue, int dir) {
        if(dir == 0) return red.y > blue.y; 
        if(dir == 1) return red.y < blue.y; 
        if(dir == 2) return red.x > blue.x; 
        return red.x < blue.x; 
    }

    private static Position moveBall(Position pos, int dir) {
        Position tmp = new Position(pos); 
        while(true) {
            int nx = tmp.x + dirx[dir]; 
            int ny = tmp.y + diry[dir]; 
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == '#') break; 
            tmp.x = nx; 
            tmp.y = ny; 
            if(board[nx][ny] == 'O') break; 
        }
        return tmp; 
    }
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
    Position(Position pos) {
        x = pos.x; 
        y = pos.y; 
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position pos = (Position) obj;
            return this.x == pos.x && this.y == pos.y; 
        }
        return false; 
    }
}

class State {
    Position red; 
    Position blue; 
    int count; 
    State(Position red, Position blue, int cnt) {
        this.red = red; 
        this.blue = blue; 
        this.count = cnt; 
    }
}
