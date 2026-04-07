import java.io.*;
import java.util.*;

public class Main {
    static final int N = 4, LEN = 16, sharkNum = -1; 
    static int[] dirx = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] diry = {0, -1, -1, -1, 0, 1, 1, 1}; 
    static int max = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st; 
        Fish[] fishes = new Fish[LEN + 1]; 
        int[][] board = new int[N][N]; 

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken()); 
                int dir = Integer.parseInt(st.nextToken()) - 1; 
                board[i][j] = num; 
                fishes[num] = new Fish(i, j, dir, num); 
            }
        }
        solution(board, fishes);
        bw.write(max + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void solution(int[][] board, Fish[] fishes) {
        Fish eatingFish = fishes[board[0][0]]; 
        fishes[board[0][0]] = null; 
        board[0][0] = sharkNum; 
        dfs(board, fishes, eatingFish.num, 0, 0, eatingFish.dir); 
    }

    private static void moveFishes(int[][] board, Fish[] fishes) {
        for(int i = 1; i <= LEN; i++) {
            Fish tmp = fishes[i]; 
            if(tmp == null) continue; 
            
            for(int d = 0; d < 8; d++) {
                int direc = (tmp.dir + d) % 8; 
                int nx = tmp.x + dirx[direc]; 
                int ny = tmp.y + diry[direc]; 
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] < 0) continue; 

                // switch fish
                int otherFish = board[nx][ny]; 

                if(board[nx][ny] > 0) { // 빈칸이 아닌 경우 
                    fishes[otherFish].x = tmp.x; 
                    fishes[otherFish].y = tmp.y; 
                }
                
                board[tmp.x][tmp.y] = otherFish; 
                board[nx][ny] = tmp.num; 
                fishes[tmp.num].x = nx; 
                fishes[tmp.num].y = ny; 
                fishes[tmp.num].dir = direc; // 방향 바꿔 
                break; 
            }
        }
    }

    private static void dfs(int[][] board, Fish[] fishes, int total, int sharkx, int sharky, int dir) {
        int[][] copyOfBoard = copyBoard(board); 
        Fish[] copyOfFishes = copyFishes(fishes); 

        moveFishes(copyOfBoard, copyOfFishes); 
        for(int cnt = 1; cnt < N; cnt++) {
            int nx = sharkx + dirx[dir] * cnt; 
            int ny = sharky + diry[dir] * cnt; 
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break; // 벗어나는 칸 
            if(copyOfBoard[nx][ny] == 0) continue; // 물고기가 없는 칸 

            Fish eatingFish = copyOfFishes[copyOfBoard[nx][ny]]; 
            copyOfFishes[copyOfBoard[nx][ny]] = null; 
            copyOfBoard[nx][ny] = sharkNum; 
            copyOfBoard[sharkx][sharky] = 0; 

            dfs(copyOfBoard, copyOfFishes, total + eatingFish.num, nx, ny, eatingFish.dir); 

            copyOfFishes[eatingFish.num] = eatingFish; 
            copyOfBoard[nx][ny] = eatingFish.num; 
            copyOfBoard[sharkx][sharky] = sharkNum; 
        }

        max = Math.max(max, total); 
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] saveBoard = new int[N][N]; 

        for(int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, saveBoard[i], 0, N);
        }

        return saveBoard; 
    }

    private static Fish[] copyFishes(Fish[] fishes) {
        Fish[] newFishes = new Fish[LEN + 1]; 
        for(int i = 0; i <= LEN; i++) {
            if(fishes[i] == null) continue; 
            Fish tmp = fishes[i]; 
            newFishes[i] = new Fish(tmp.x, tmp.y, tmp.dir, tmp.num); 
        }
        return newFishes; 
    }
}

class Fish {
    int x, y, dir, num; 

    Fish(int x, int y, int d, int n) {
        this.x = x; 
        this.y = y; 
        this.dir = d; 
        this.num = n; 
    }
}