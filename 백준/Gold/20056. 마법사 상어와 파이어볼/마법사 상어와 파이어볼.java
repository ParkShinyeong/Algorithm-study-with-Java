import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dirx = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] diry = {0, 1, 1, 1, 0, -1, -1, -1}; 
    static ArrayList<Fireball>[] fireballs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        fireballs = new ArrayList[N * N + 1]; 

        for(int i = 0; i <= N * N; i++) {
            fireballs[i] = new ArrayList<>(); 
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int r = Integer.parseInt(st.nextToken()) - 1; 
            int c = Integer.parseInt(st.nextToken()) - 1; 
            int m = Integer.parseInt(st.nextToken()); 
            int s = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken()); 
            int pos = r * N + c;
            fireballs[pos].add(new Fireball(r, c, pos, m, s, d));
        }
        
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        for(int i = 0; i < K; i++) {
            moveAllFireball(); 
            putFireballTogether(); 
        }

        int totalM = 0; 
        for(ArrayList<Fireball> fireballList: fireballs) {
            for(Fireball fireball: fireballList)
            totalM += fireball.m; 
        }
        return totalM; 
    }

    

    private static void moveAllFireball() {
        ArrayList<Fireball>[] newFireballs = newNextMap();

        for(ArrayList<Fireball> fireballList: fireballs) {
            for(Fireball fireball: fireballList) {
                int nx = (fireball.r + dirx[fireball.d] * (fireball.s % N) + N) % N;
                int ny = (fireball.c + diry[fireball.d] * (fireball.s % N) + N) % N;

                fireball.r = nx; 
                fireball.c = ny; 

                int newPos = nx * N + ny; 
                newFireballs[newPos].add(fireball); 
            }
        }
        fireballs = newFireballs; 
    }

    private static ArrayList<Fireball>[] newNextMap() {
        ArrayList<Fireball>[] newFireballs = new ArrayList[N * N + 1]; 

        for(int i = 0; i <= N * N; i++) {
            newFireballs[i] = new ArrayList<>(); 
        }

        return newFireballs; 
    }

    private static void putFireballTogether() {
        for(int i = 0; i < N * N; i++) {
            int cnt = fireballs[i].size();
            if(cnt < 2) continue; 

            int sumM = 0, sumS = 0; 
            int evenCnt = 0;  
            Fireball first = fireballs[i].get(0); 
            int r = first.r, c = first.c; 

            for(Fireball tmp: fireballs[i]) {
                sumM += tmp.m; 
                sumS += tmp.s; 
                if(tmp.d % 2 == 0) evenCnt++; 
            }
            
            fireballs[i] = new ArrayList<>(); 
            if(sumM / 5 == 0) continue;            
            int d = evenCnt == cnt || evenCnt == 0 ? 0 : 1; 
            for(int dir = d;  dir < 8; dir += 2) {
                fireballs[i] .add(new Fireball(r, c, i, sumM / 5, sumS / cnt, dir)); 
            }
        }
    }
}

class Fireball {
    int r, c, pos, m, s, d; 
    Fireball(int r, int c, int pos, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.pos = pos; 
        this.s = s; 
        this.m = m; 
        this.d = d; 
    }
}