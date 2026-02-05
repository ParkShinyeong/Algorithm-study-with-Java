import java.io.*;
import java.util.*;

public class Main {
    static int N, L; 
    static int[][] board; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 
        board = new int[N][N]; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int answer = 0;  

        for(int i = 0; i < N; i++) {
            if(solution(board[i])) answer++; 
            int[] road = new int[N]; 
            for(int j = 0; j < N; j++) {
                road[j] = board[j][i]; 
            }
            if(solution(road)) answer++; 
        }
        
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static boolean solution(int[] road) {
        boolean[] isSetLamp = new boolean[N]; 
        int prev = road[0]; 
        boolean flag = true; 

        for(int i = 1; i < N; i++) {
            int tmp = road[i]; 

            if(prev == tmp) continue; 
            if(Math.abs(prev - tmp) != 1) return false; 
            int cnt = 0; 
            if(tmp < prev) {
                int tmpIdx = i; 
                while(tmpIdx < N) {
                    if(road[tmpIdx] != tmp || isSetLamp[tmpIdx]) break; 
                    tmpIdx++; 
                    cnt++; 
                }

                if(cnt >= L) {
                    for(int j = i; j < i + L; j++) {
                        isSetLamp[j] = true; 
                    }
                } else return false; 
            } else {
                int tmpIdx = i - 1; 
                while(tmpIdx >= 0) {
                    if(road[tmpIdx] != prev || isSetLamp[tmpIdx]) break; 
                    tmpIdx--; 
                    cnt++; 
                } 
                if(cnt >= L) {
                    for(int j = i - 1; j >= i - L; j--) {
                        isSetLamp[j] = true;  
                    }
                } else return false; 
            }
            prev = tmp; 
        }
        return flag; 
    }
}