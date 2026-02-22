import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static Space[] spaces; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        spaces = new Space[M]; 

        for(int i = 0; i < M; i++) {
            spaces[i] = new Space(N); 
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                spaces[i].planets[j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(solution())); 
        
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int[][] compressed = new int[M][N]; 
        int[][] spacePlanetIdx = new int[M][N]; 
        for(int i = 0; i < M; i++) {
            // 배열 복사 
            System.arraycopy(spaces[i].planets, 0, compressed[i], 0, N); 
            // 정렬
            Arrays.sort(compressed[i]); 
            // 중복 제거 
            int prev = 0; 
            for(int j = 1; j < N; j++) {
                if(compressed[i][j] != compressed[i][prev]) {
                    compressed[i][++prev] = compressed[i][j]; 
                }
            }
            // 이진탐색으로 위치 탐색 
            for(int j = 0; j < N; j++) {
                int p = spaces[i].planets[j]; 
                int idx = Arrays.binarySearch(compressed[i], 0, prev + 1, p); 
                spacePlanetIdx[i][j] = idx; 
            }
        }
        int cnt = 0; 
        for(int i = 0; i < M; i++) {
            for(int j = i + 1; j < M; j++) {
                if(Arrays.equals(spacePlanetIdx[i], spacePlanetIdx[j])) cnt++; 
            }
        }
        return cnt;
    }
}

class Space {
    int[] planets; 
    Space(int N) {
        planets = new int[N]; 
    }
}