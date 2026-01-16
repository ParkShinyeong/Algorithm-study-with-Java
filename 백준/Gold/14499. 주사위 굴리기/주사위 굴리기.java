import java.io.*;
import java.util.*;

public class Main {
    static final int diceCnt = 6; 
    static int N, M, x, y, K;
    static int[][] board; 
    static int[] command; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        x = Integer.parseInt(st.nextToken()); 
        y = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        
        board = new int[N][M]; 
        command = new int[K]; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken()); 
        }
        

        ArrayList<Integer> answer = rollingDice(); 
        for(int num : answer) {
            bw.write(num + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static ArrayList<Integer> rollingDice() {
        int[] dirx = {0, 0, -1, 1}; 
        int[] diry = {1, -1, 0, 0}; 
        int[] dice = new int[diceCnt]; 
        int bottomIdx = 5;  // 현재 바닥면 인덱스 
        int southIdx = 1; 
        int eastIdx = 3; 
        int tmpX = x; 
        int tmpY = y; 
        ArrayList<Integer> answer = new ArrayList<>(); 

        for(int i = 0; i < K; i++) {
            int tmpCommand = command[i] - 1; 
            int nx = tmpX + dirx[tmpCommand];
            int ny = tmpY + diry[tmpCommand]; 
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; 
            
            int tmpBt = bottomIdx; 
            int tmpSt = southIdx; 
            int tmpEs = eastIdx; 

            switch (tmpCommand) {
                case 0: // east
                    bottomIdx = tmpEs; 
                    eastIdx = diceCnt - 1 - tmpBt; 
                    break; 
                case 1: // west
                    bottomIdx = diceCnt - 1 - tmpEs; 
                    eastIdx = tmpBt; 
                    break; 
                case 2: // north
                    bottomIdx = diceCnt - 1 - tmpSt; 
                    southIdx = tmpBt; 
                    break; 
                case 3: // south
                    bottomIdx = tmpSt; 
                    southIdx = diceCnt - 1 - tmpBt;
                    break;
            }
            
            if(board[nx][ny] == 0) {
                board[nx][ny] = dice[bottomIdx]; 
            } else {
                dice[bottomIdx] = board[nx][ny]; 
                board[nx][ny] = 0; 
            }
            tmpX = nx; 
            tmpY = ny; 
            answer.add(dice[diceCnt - 1 - bottomIdx]); 
        }
        return answer; 
    }
}