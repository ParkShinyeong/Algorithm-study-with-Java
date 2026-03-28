import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt; 
    static boolean[][] graph; 
    static int[] students; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        cnt = N * N; 
        graph = new boolean[cnt][cnt]; 
        students = new int[cnt]; 

        StringTokenizer st; 
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine()); 
            int student = Integer.parseInt(st.nextToken()) - 1; 
            students[i] = student; 
            for(int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken()) - 1; 
                graph[student][like] = true; 
            }
        }
        bw.write(seatStudent() + "");  
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }


    private static int seatStudent() {
        int[][] seats = new int[N][N]; 
        for(int i = 0; i < N; i++){ 
            Arrays.fill(seats[i], -1); 
        }

        for(int i = 0; i < cnt; i++) {
            int tmp = students[i]; 
            setStudent(seats, tmp); 
        }

        int satisfaction = 0; 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int tmp = seats[i][j]; 
                int friendCnt = 0; 
                for(int d = 0; d < 4; d++) {
                    int nx = i + dirx[d]; 
                    int ny = j + diry[d]; 

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
                    int nxt = seats[nx][ny]; 
                    if(graph[tmp][nxt]) friendCnt++; 
                }

                if(friendCnt == 4) satisfaction += 1000; 
                else if(friendCnt == 3) satisfaction += 100; 
                else if(friendCnt == 2) satisfaction += 10; 
                else if(friendCnt == 1) satisfaction += 1; 
            }
        }
        return satisfaction; 
    }

    private static void setStudent(int[][] seats, int tmpStudent) {
        PriorityQueue<Seat> pq = new PriorityQueue<>(); 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(seats[i][j] >= 0) continue; // 이미 누가 차지하고 있는 자리 
                int emptyCnt = 0; 
                int favorCnt = 0; 
                for(int d = 0; d < 4; d++) {
                    int nx = i + dirx[d]; 
                    int ny = j + diry[d]; 

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
                    int friend = seats[nx][ny]; 
                    if(seats[nx][ny] < 0) emptyCnt++; 
                    else if(graph[tmpStudent][friend]) favorCnt++;
                }
                pq.offer(new Seat(emptyCnt, favorCnt, i, j)); 
            }
        }
        Seat seat = pq.poll();
        seats[seat.x][seat.y] = tmpStudent;  
    }
}

class Seat implements Comparable<Seat>{
    int e, f, x, y; 
    Seat (int e, int f, int x, int y) {
        this.e = e; 
        this.f = f; 
        this.x = x; 
        this.y = y; 
    }

    @Override
    public int compareTo(Seat o) {
        if(this.f != o.f) return o.f - this.f; 
        if(this.e != o.e) return o.e - this.e; 
        if(this.x != o.x) return this.x - o.x; 
        return this.y - o.y; 
    }
}