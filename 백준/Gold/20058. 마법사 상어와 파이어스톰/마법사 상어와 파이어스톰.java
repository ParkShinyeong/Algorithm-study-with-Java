import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, len; 
    static int[][] ices; 
    static int[] commands; 
    static int[] dirx = {0, 0, 1, -1}; 
    static int[] diry = {1, -1, 0, 0}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        Q = Integer.parseInt(st.nextToken()); 
        len = 1; 
        for(int i = 0; i < N; i++) {
            len *= 2; 
        }

        ices = new int[len][len]; 
        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < len; j++) {
                ices[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        commands = new int[Q]; 
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < Q; i++) {
            commands[i] = Integer.parseInt(st.nextToken()); 
        }

        bw.write(solution()); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static String solution() {
        for(int i = 0; i < Q; i++) {
            rotateBoard(commands[i]); 
            checkAndMeltIces(); 
        }
        return getAnswer(); 
    }

    private static void rotateBoard(int L) {
        if(L == 0) return; 

        int size = 1; 
        for(int i = 0; i < L; i++) {
            size *= 2; 
        }

        int[][] newBoard = new int[len][len]; 
        
        for(int i = 0; i < len; i += size) {
            for(int j = 0; j < len; j += size) {
                rotateIces(size, i, j, newBoard); 
            }
        }
        ices = newBoard; 
    }


    private static void rotateIces(int size, int sx, int sy, int[][] newBoard) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                newBoard[sx + j][sy + (size - i - 1)] = ices[sx + i][sy + j]; 
            }
        }
    }

    private static void checkAndMeltIces() {
        ArrayList<int[]> meltIce = new ArrayList<>(); 
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(ices[i][j] == 0) continue; 
                int cnt = 0; 
                for(int d = 0; d < 4; d++) {
                    int nx = i + dirx[d]; 
                    int ny = j + diry[d]; 
                    if(nx < 0 || ny < 0 || nx >= len || ny >= len || ices[nx][ny] == 0) continue; 
                    cnt++; 
                }
                if(cnt < 3) meltIce.add(new int[] {i, j}); 
            }
        }

        for(int[] pos: meltIce) {
            ices[pos[0]][pos[1]]--; 
        }
    }

    private static String getAnswer() {
        int totalIce = 0; 
        int max = 0; 
        boolean[][] visit = new boolean[len][len]; 

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                totalIce += ices[i][j]; 
                if(visit[i][j] || ices[i][j] == 0) continue; 
                max = Math.max(max, getIceSize(visit, i, j)); 
            }
        }

        return totalIce + "\n" + max; 
    }

    private static int getIceSize(boolean[][] visit, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>(); 
        queue.offer(new int[]{x, y}); 
        visit[x][y] = true; 
        int size = 0; 
        
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll(); 
            size++; 
            for(int d = 0; d < 4; d++) {
                int nx = tmp[0] + dirx[d]; 
                int ny = tmp[1] + diry[d]; 
                if(nx < 0 || ny < 0 || nx >= len || ny >= len || ices[nx][ny] == 0 || visit[nx][ny]) continue; 
                visit[nx][ny] = true; 
                queue.offer(new int[]{nx, ny}); 
            }
        }
        return size; 
    }
}