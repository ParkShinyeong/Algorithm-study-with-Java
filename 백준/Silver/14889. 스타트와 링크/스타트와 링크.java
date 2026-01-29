import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[][] arr; 
    static int start, link, ans; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N][N]; 

        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        ans = Integer.MAX_VALUE; 

        seperateTeam(0, 0, new int[N]);
        bw.write(String.valueOf(ans)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void seperateTeam(int cnt, int idx, int[] team) {
        if(cnt == N / 2) {
            getPower(0, 0, team, new int[2], 0);
            getPower(0, 0, team, new int[2], 1);
            ans = Math.min(ans, Math.abs(start - link)); 
            start = 0; 
            link = 0; 
            return; 
        }

        for(int i = idx; i < N; i++) {
            team[i] = 1; // 1인 경우 start팀 
            seperateTeam(cnt + 1, i + 1, team);
            team[i] = 0; 
        }
    }

    static void getPower(int cnt, int idx, int[] team, int[] member, int teamcode) {
        if(cnt == 2) {
            if(teamcode == 1) {
                start += arr[member[0]][member[1]]; 
                start += arr[member[1]][member[0]];
            } else {
                link += arr[member[0]][member[1]]; 
                link += arr[member[1]][member[0]]; 
            }
            return; 
        }

        for(int i = idx; i < N; i++) {
            if(team[i] != teamcode) continue; 
            member[cnt] = i; 
            getPower(cnt + 1, i + 1, team, member, teamcode);
        }
    }
}