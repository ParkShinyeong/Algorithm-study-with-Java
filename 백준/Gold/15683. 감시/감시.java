import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer; 
    static int[][] office; 
    static ArrayList<Cctv> cctvs; 
    static int[] dirx = {-1, 0, 1, 0}; 
    static int[] diry = {0, -1, 0, 1}; 
    static int[][][] direction = {
        {}, 
        {{0}, {1}, {2}, {3}}, 
        {{0, 2}, {1, 3}}, 
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, 
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, 
        {{0, 1, 2, 3}}
    }; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
       
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        office = new int[N][M]; 
        cctvs = new ArrayList<>(); 
        answer = Integer.MAX_VALUE; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken()); 
                if(office[i][j] > 0 && office[i][j] < 6) cctvs.add(new Cctv(i, j, office[i][j])); 
            }
        }

        setCctv(0);
        bw.write(answer + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void setCctv(int idx){
        if(idx == cctvs.size()) {
            int blindCnt = getBlindSpotCount(); 
            answer = Math.min(answer, blindCnt); 
            return; 
        }

        Cctv cctv = cctvs.get(idx); 
        ArrayDeque<int[]> secureSpot = new ArrayDeque<>();
        
        for(int[] tmpDir: direction[cctv.num]) {
            for(int d = 0; d < tmpDir.length; d++) { // 한 방향을 체크 
                int cnt = 1; 
                while(true) {
                    int nx = cctv.x + dirx[tmpDir[d]] * cnt; 
                    int ny = cctv.y + diry[tmpDir[d]] * cnt;
                    cnt++; 
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || office[nx][ny] == 6) break; 
                    if(office[nx][ny] > 0 && office[nx][ny] < 6) continue; 
                    office[nx][ny]--; 
                    secureSpot.offer(new int[]{nx, ny}); 
                }
            }
            setCctv(idx + 1);
            while(!secureSpot.isEmpty()) {
                int[] tmp = secureSpot.poll(); 
                office[tmp[0]][tmp[1]]++; 
            }
        }
    }
    
    static int getBlindSpotCount() {
        int cnt = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(office[i][j] == 0) cnt++; 
            }
        }
        return cnt; 
    }

}

class Cctv {
    int x, y, num; 

    Cctv(int x, int y, int num) {
        this.x = x; 
        this.y = y; 
        this.num = num; 
    }
}