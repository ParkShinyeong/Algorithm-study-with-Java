import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String[] input = br.readLine().split(" "); 
        int N = Integer.parseInt(input[0]); 
        int M = Integer.parseInt(input[1]); 
        int[][] campus = new int[N][M]; 
        int dox = 0, doy = 0; 
        for(int i = 0; i < N; i++) {
            String str = br.readLine(); 
            for(int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j); 
                if(campus[i][j] == 'I') {
                    dox = i; 
                    doy = j; 
                }
            }
        }

        int answer = getPeople(campus, N, M, dox, doy); 
        bw.write(answer == 0 ? "TT" : answer + ""); 
        bw.flush();
        bw.close();
        br.close();
    }

    static int getPeople(int[][] campus, int N, int M, int dox, int doy) {
        int[] dx = {-1, 0, 1, 0}; 
        int[] dy = {0, 1, 0, -1}; 
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>(); 
        boolean[][] visit = new boolean[N][M]; 

        q.offer(new int[] {dox, doy}); 
        visit[dox][doy] = true; 

        while(!q.isEmpty()) {
            int[] pos = q.poll(); 
            int x = pos[0], y = pos[1]; 
            if(campus[x][y] == 'P') cnt++; 
            for(int i = 0; i < 4; i++) {
                int tmpx = x + dx[i]; 
                int tmpy = y + dy[i]; 
                if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= M) {
                    continue;
                }
                if(campus[tmpx][tmpy] == 'X') {
                    continue; 
                }
                if(!visit[tmpx][tmpy]) {
                    visit[tmpx][tmpy] = true; 
                    q.offer(new int[] {tmpx , tmpy}); 
                }
            }
        }
        return cnt; 
    }
    
}
