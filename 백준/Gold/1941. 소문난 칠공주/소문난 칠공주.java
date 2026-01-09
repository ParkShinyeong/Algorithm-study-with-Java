import java.io.*;
import java.util.*;

public class Main {
    static char[][] classroom; 
    static int[] dirx = new int[] {1, -1, 0, 0}; 
    static int[] diry = new int[] {0, 0, 1, -1}; 
    static int answer = 0; 
    static int[] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        classroom = new char[5][5];  
        arr = new int[25]; 
        for(int i = 0; i < 25; i++) {
            arr[i] = i; 
        }

        for(int i = 0; i < 5; i++) {
            String input = br.readLine(); 
            for(int j = 0; j < 5; j++) {
                classroom[i][j] = input.charAt(j); 
            }
        }

        recur(0, 0, 0, new int[7]); 

        bw.write(answer + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void recur(int cnt, int sCnt, int idx, int[] seq) {
        if(cnt == 7) {
            if(sCnt >= 4 && checkConnection(seq)) answer++; 
            return; 
        }

        for(int i = idx; i < 25; i++) {
            seq[cnt] = arr[i]; 
            recur(cnt + 1, classroom[arr[i] / 5][arr[i] % 5] == 'S' ? sCnt + 1 : sCnt, i + 1, seq); 
        }
    }

    static boolean checkConnection(int[] seq) {
        int[] isVisited = new int[25]; 

        for(int num: seq) {
            isVisited[num]++; 
        }
        
        Queue<Integer> q = new ArrayDeque<>(); 
        q.offer(seq[0]); 
        isVisited[seq[0]]++;
        int cnt = 1; 

        while(!q.isEmpty()) {
            int tmp = q.poll(); 
            int tmpx = tmp / 5; 
            int tmpy = tmp % 5; 
            for(int d = 0; d < 4; d++) {
                int nx = tmpx + dirx[d]; 
                int ny = tmpy + diry[d]; 
                int nxt = nx * 5 + ny; 

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || isVisited[nxt] != 1) continue; 
                q.offer(nxt); 
                cnt++; 
                isVisited[nxt]++; 
            }
        }

        if(cnt != 7) return false; 
        return true; 
    }
}