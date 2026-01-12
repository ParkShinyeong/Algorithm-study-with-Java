import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, answer;
    static Sticker[] stickers;  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        answer = 0; 

        stickers = new Sticker[K]; 

        for(int s = 0; s < K; s++) {
            st = new StringTokenizer(br.readLine()); 
            int n = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 

            stickers[s] = new Sticker(n, m); 

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()); 
                for(int j = 0; j < m; j++) {
                    stickers[s].sticker[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
        }

        dfs(0, new int[N][M]); 
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void dfs(int idx, int[][] laptop) {
        if(idx == K) { // base condition
            int cnt = 0; 
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(laptop[i][j] == 1) cnt++; 
                }
            }
            answer = Math.max(answer, cnt); 
            return; 
        }

        boolean isSuccess = false; 
        Sticker tmpSticker = stickers[idx]; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                isSuccess = canPutSticker(i, j, laptop, idx); 

                if(isSuccess) {
                    putSticker(i, j, laptop, idx);
                    dfs(idx + 1, laptop); 
                    return; 
                } 
            }
        }

        if(!isSuccess) {
            if(tmpSticker.rotateCnt == 4) { 
                dfs(idx + 1, laptop);
            } else { 
                Sticker newSticker = rotateSticker90(tmpSticker); 
                stickers[idx] = newSticker; 
                dfs(idx, laptop); 
            }
         }
    }

    static boolean canPutSticker(int sx, int sy, int[][] laptop, int idx) {
        Sticker tmpSticker = stickers[idx]; 

        for(int i = 0; i < tmpSticker.n; i++) {
            for(int j = 0; j < tmpSticker.m; j++) {
                if(tmpSticker.sticker[i][j] == 0) continue; 
                int nx = sx + i; 
                int ny = sy + j; 
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || laptop[nx][ny] == 1) return false;  
            }
        }  
        return true; 
    }

    static void putSticker(int sx, int sy, int[][] laptop, int idx) {
        Sticker tmpSticker = stickers[idx]; 

        for(int i = 0; i < tmpSticker.n; i++) {
            for(int j = 0; j < tmpSticker.m; j++) {
                if(tmpSticker.sticker[i][j] == 0) continue; 
                int nx = sx + i; 
                int ny = sy + j; 
                laptop[nx][ny] = 1; 
            }
        }  
    }

    static Sticker rotateSticker90(Sticker sticker) {
        int[][] tmpSticker = sticker.sticker; 
        int[][] rotateSticker = new int[sticker.m][sticker.n]; 

        for(int i = 0; i < sticker.n; i++) {
            for(int j = 0; j < sticker.m; j++) {
                rotateSticker[j][sticker.n - 1 - i] = tmpSticker[i][j]; 
            }
        }

        Sticker newSticker = new Sticker(sticker.m, sticker.n); 
        newSticker.sticker = rotateSticker; 
        newSticker.rotateCnt = sticker.rotateCnt + 1; 
        return newSticker; 
    }
}

class Sticker {
    int n, m; 
    int[][] sticker; 
    int rotateCnt; 

    Sticker (int n, int m) {
        this.n = n; 
        this.m = m; 
        sticker = new int[n][m]; 
        rotateCnt = 0; 
    }
}