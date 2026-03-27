import java.io.*;
import java.util.*;

public class Main {
    static int N, min; 
    static int[] populations; 
    static ArrayList<Integer>[] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        populations = new int[N + 1]; 
        graph = new ArrayList[N + 1]; 

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        for(int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken()); 
            graph[i] = new ArrayList<>(); 
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int cnt = Integer.parseInt(st.nextToken()); 

            for(int j = 0; j < cnt; j++) {
                graph[i].add(Integer.parseInt(st.nextToken())); 
            }
        }

        min = Integer.MAX_VALUE; 

        dfs(0, 0, new boolean[N + 1]); 
        if(min == Integer.MAX_VALUE) bw.write("-1"); 
        else bw.write(min + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int cnt, int idx, boolean[] areas) {
        if(checkAreas(areas)) {
            min = Math.min(calcPopulations(areas), min); 
        }

        if(cnt == N / 2) {
            return; 
        }

        for(int i = idx; i <= N; i++) {
            areas[i] = true;
            dfs(cnt + 1, i + 1, areas); 
            areas[i] = false;  
        }
    }

    private static boolean checkAreas(boolean[] areas) {
        int area1Cnt = 0, area2Cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(areas[i]) area1Cnt++; 
            else area2Cnt++;
        } 

        if(area1Cnt == 0 || area2Cnt == 0) return false; 

        boolean[] isVisit = new boolean[N + 1]; 
        for(int i = 1; i <= N; i++) {
            if(isVisit[i]) continue; 

            int cnt = 1; 
            isVisit[i] = true; 
            boolean area = areas[i]; 

            Queue<Integer> queue = new ArrayDeque<>(); 
            queue.offer(i); 

            while(!queue.isEmpty()) {
                int tmp = queue.poll(); 
                for(int nxt: graph[tmp]) {
                    if(isVisit[nxt] || areas[nxt] != area) continue; 
                    isVisit[nxt] = true; 
                    queue.offer(nxt); 
                    cnt++; 
                }
            }

            if((area && area1Cnt != cnt) || (!area && area2Cnt != cnt)) {
                return false; // 선거구가 다 연결되어 있지 않음
            }
        }

        return true; 
    }

    private static int calcPopulations(boolean[] areas) {
        int area1 = 0, area2 = 0; 
        for(int i = 1; i <= N; i++) {
            if(areas[i]) area1 += populations[i]; 
            else area2 += populations[i]; 
        }
        return Math.abs(area1 - area2); 
    }

}