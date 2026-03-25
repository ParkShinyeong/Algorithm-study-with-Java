import java.io.*;
import java.util.*;

public class Main {
    static int N, K, len;
    static int[] conveyor; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken());
        len = 2 * N;  
        conveyor = new int[len]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < len; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken()); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        boolean[] isRobot = new boolean[len]; 
        ArrayList<Integer> robots = new ArrayList<>(); 

        int time = 0; 
        while(true) {
            moveConveyor(); 
            moveRobotWithConveyor(robots, isRobot); 
            
            moveRobots(robots, isRobot); 
            if(conveyor[0] > 0 && !isRobot[0]) {
                isRobot[0] = true; 
                conveyor[0]--; 
                robots.add(0); 
            }
            time++; 
            if(checkConveyor()) return time;  
        }
    }

    private static void moveRobots(ArrayList<Integer> robots, boolean[] isRobot) {
        for(int i = 0; i < robots.size(); i++) {
            int tmp = robots.get(i); 
            int nxt = (tmp + 1) % len; 
            if(isRobot[nxt] || conveyor[nxt] == 0) { // 이동하는 칸 내구도가 없다면 / 다른 로봇이 있다면
                continue; 
            }
            isRobot[tmp] = false; 
            conveyor[nxt]--; 
            if(nxt == N - 1) {
                robots.remove(i--); 
                continue; 
            }
            robots.set(i, nxt); 
            isRobot[nxt] = true; 
        }
    }

    private static boolean checkConveyor() {
        int cnt = 0; 
        for(int i = 0; i < len; i++) {
            if(conveyor[i] == 0) cnt++; 
        }
        return cnt >= K; 
    }

    private static void moveRobotWithConveyor(ArrayList<Integer> robots, boolean[] isRobot) {
        for(int i = 0; i < robots.size(); i++) {
            robots.set(i, (robots.get(i) + 1) % len); 
            if(robots.get(i) == N - 1) robots.remove(i--); 
        }

        boolean last = isRobot[len - 1]; 
        for(int i = len - 1; i > 0; i--) {
            isRobot[i] = isRobot[i - 1]; 
        }
        isRobot[0] = last; 

        isRobot[N - 1] = false; 
    }

    private static void moveConveyor() {
        int last = conveyor[len - 1]; 
        for(int i = len - 1; i > 0; i--) {
            conveyor[i] = conveyor[i - 1]; 
        }
        conveyor[0] = last; 
    }
}