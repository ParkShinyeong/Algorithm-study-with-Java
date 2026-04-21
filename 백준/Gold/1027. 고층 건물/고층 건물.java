import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[] buildings; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        buildings = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int maxCnt = 0; 
        for(int x = 0; x < N; x++) {
            int cnt = 0; 
            int y = buildings[x]; 
            double max = -Double.MAX_VALUE; 
            double min = Double.MAX_VALUE; 

            for(int x2 = x + 1; x2 < N; x2++) {
                int y2 = buildings[x2]; 
                double inclination = (double)(y2 - y)/(x2 - x); 
                if(max < inclination) {
                    max = inclination; 
                    cnt++; 
                }
            }


            for(int x2 = x - 1; x2 >= 0; x2--) {
                int y2 = buildings[x2]; 
                double inclination = (double)(y2 - y)/(x2 - x); 
                if(min > inclination) {
                    min = inclination; 
                    cnt++; 
                }
            }
            maxCnt = Math.max(cnt, maxCnt); 
        }
        return maxCnt; 
    }
}