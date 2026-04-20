import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K; 
    static ArrayList<Position> stars; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        stars = new ArrayList<>(); 
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()); 
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 
            stars.add(new Position(x, y)); 
        }
        bw.write(K - solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int max = 0; 
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < K; j++) {
                Position s1 = stars.get(i); 
                Position s2 = stars.get(j); 

                int sx = s1.x; 
                int sy = s2.y; 
                int ex = sx + L; 
                int ey = sy + L; 

                int cnt = 0; 

                for(Position star : stars) {
                    if(sx <= star.x && star.x <= ex
                        && sy <= star.y && star.y <= ey
                    ) cnt++; 
                }

                max = Math.max(max, cnt); 
            }
        }
        return max; 
    }

    
}

class Position {
    int x, y; 
    Position(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}