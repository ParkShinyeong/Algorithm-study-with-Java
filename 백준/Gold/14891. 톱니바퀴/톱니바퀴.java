import java.io.*;
import java.util.*;

public class Main {
    static final int N = 4; 
    static final int M = 8; 
    static int K; 
    static Gear[] gears; 
    static int[] dir = {1, -1}; 
    static int[] top; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        gears = new Gear[N]; 
        top = new int[N]; 

        for(int i = 0; i < N; i++) {
            gears[i] = new Gear(br.readLine()); 
        }
        
        K = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()); 
            int gearNum = Integer.parseInt(st.nextToken()) - 1; 
            int direction = Integer.parseInt(st.nextToken()); 
            ArrayList<int[]> rotateGearList = checkRotateGear(gearNum, direction); 
            rotateGears(rotateGearList);
        }

        bw.write(String.valueOf(getScore())); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    
    static ArrayList<int[]> checkRotateGear(int gearNum, int direction) {
        boolean[] isVisited = new boolean[N]; 
        isVisited[gearNum] = true; 

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {gearNum, direction}); 

        ArrayList<int[]> rotateGears = new ArrayList<>(); 
        rotateGears.add(new int[] {gearNum, direction}); 

        while(!q.isEmpty()) {
            int[] tmp = q.poll(); 
            int tmpNum = tmp[0]; 
            int tmpDir = tmp[1]; 
            Gear tmpGear = gears[tmpNum]; 

            for(int d = 0; d < 2; d++) {
                int nxt = tmpNum + dir[d]; 
                if(nxt < 0 || nxt >= N || isVisited[nxt]) continue; 
                Gear nxtGear = gears[nxt]; 
                if(dir[d] == 1) {
                    int tmpGearPos = (tmpGear.topIdx + 2) % 8; 
                    int nxtGearPos = (nxtGear.topIdx + 6) % 8; 
                    if(tmpGear.cogs[tmpGearPos] == nxtGear.cogs[nxtGearPos]) continue; 
                } else {
                    int tmpGearPos = (tmpGear.topIdx + 6) % 8; 
                    int nxtGearPos = (nxtGear.topIdx + 2) % 8; 
                    if(tmpGear.cogs[tmpGearPos] == nxtGear.cogs[nxtGearPos]) continue;
                }
                q.offer(new int[] {nxt, -tmpDir}); 
                rotateGears.add(new int[] {nxt, -tmpDir}); 
                isVisited[nxt] = true; 
            }
        }
        return rotateGears; 
    }

    static void rotateGears(ArrayList<int[]> rotateGearList) {
        for(int[] gearInfo: rotateGearList) {
            Gear gear = gears[gearInfo[0]];
            if(gearInfo[1] == 1) { // 시계 방향 
                gear.topIdx = (gear.topIdx + 7) % 8; 
            } else {
                gear.topIdx = (gear.topIdx + 1) % 8; 
            }
        }
    }

    static int getScore() {
        int score = 0; 
        for(int i = 0; i < N; i++) {
            Gear gear = gears[i]; 
            if(gear.cogs[gear.topIdx] == 0) continue; 
            score += Math.pow(2, i); 
        }
        return score; 
    }

}

class Gear {
    int[] cogs; 
    int topIdx;  
    Gear(String input) {
        cogs = new int[8]; 
        for(int i = 0; i < 8; i++) {
            cogs[i] = input.charAt(i) - '0'; 
        }
        topIdx = 0; 
    }
}