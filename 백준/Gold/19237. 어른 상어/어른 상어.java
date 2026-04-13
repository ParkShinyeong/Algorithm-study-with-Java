import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K; 
    static Shark[] sharks; 
    static int[][][] board;
    static int[] dirx = {-1, 1, 0, 0}; 
    static int[] diry = {0, 0, -1, 1} ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        sharks = new Shark[M + 1]; 
        board = new int[N][N][2]; 

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken()); 
                board[i][j] = new int[] {input, K}; // 상어 번호, 시간 
                if(input == 0) continue; 
                sharks[input] = new Shark(i, j, input); 
            }
        }
        st = new StringTokenizer(br.readLine()); 
        for(int i = 1; i <= M; i++) {
            sharks[i].tmpDir = Integer.parseInt(st.nextToken()) - 1; 
        }

        for(int i = 1; i <= M; i++) {
            int[][] priority = sharks[i].priority; 
            for(int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine()); 
                for(int k = 0; k < 4; k++) {
                    priority[j][k] = Integer.parseInt(st.nextToken()) - 1; 
                }
            }
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int totalShark = M; 
        
        for(int i = 1; i <= 1000; i++) {
            for(int j = 1; j <= M; j++) { // 1번 상어부터 차례대로 이동 
                Shark shark = sharks[j]; 
                if(!shark.status) continue; 
                checkSharkNextPosition(shark);
            }
            decreaseTime(); 
            int sharkCnt = moveShark(); 
            if(sharkCnt == 1) return i; 
        }
        return -1; 
    }

    private static int moveShark() {
        int sharkCnt = 0; 
        for(int i = 1; i <= M; i++) {
            Shark shark = sharks[i]; 
            if(!shark.status)continue; 

            int n = board[shark.x][shark.y][0]; 
            if(n > 0 && n < shark.num && board[shark.x][shark.y][1] == K) {
                shark.status = false; 
                continue; 
            }
            board[shark.x][shark.y][0] = shark.num; 
            board[shark.x][shark.y][1] = K; 
            sharkCnt++; 
        }
        return sharkCnt; 
    }

    private static void decreaseTime() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j][0] == 0) continue; 
                board[i][j][1]--; // 시간 줄이기 
                if(board[i][j][1] == 0) board[i][j][0] = 0;  // 시간이 다 지나면 냄새는 사라짐 
            }
        }
    }

    private static void checkSharkNextPosition(Shark shark) {
        
        for(int d = 0; d < 4; d++) {
            int pd = shark.priority[shark.tmpDir][d]; 
            int nx = shark.x + dirx[pd]; 
            int ny = shark.y + diry[pd]; 
            if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny][0] != 0) continue; 
            switchSharkPosition(shark, nx, ny, pd); 
            return; 
        }

        for(int d = 0; d < 4; d++) {
            int pd = shark.priority[shark.tmpDir][d]; 
            int nx = shark.x + dirx[pd]; 
            int ny = shark.y + diry[pd]; 
            if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny][0] != shark.num) continue; 
            switchSharkPosition(shark, nx, ny, pd); 
            return; 
        }

    }

    private static void switchSharkPosition(Shark shark, int nx, int ny, int dir) {
            shark.x = nx; 
            shark.y = ny; 
            shark.tmpDir = dir; 
    }
}

class Shark {
    int x, y, num, tmpDir; 
    boolean status; 
    int[][] priority = new int[4][4]; 
    Shark(int x, int y, int num) {
        this.x = x; 
        this.y = y; 
        this.num = num; 
        status = true; 
    }
}