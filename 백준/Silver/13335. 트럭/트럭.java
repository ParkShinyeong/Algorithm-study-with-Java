import java.io.*;
import java.util.*;

public class Main {
    static int n, w, L; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        n = Integer.parseInt(st.nextToken()); // 트럭 수 
        w = Integer.parseInt(st.nextToken()); // 다리 길이 
        L = Integer.parseInt(st.nextToken()); // 다리 최대 하중 

        st = new StringTokenizer(br.readLine()); 
        Queue<Integer> trucks = new ArrayDeque<>(); 

        for(int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken())); 
        }
        int answer = moveTrucks(trucks); 
        bw.write(String.valueOf(answer)); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    static int moveTrucks(Queue<Integer> trucks) {
        int time = 0;

        Queue<int[]> bridge = new ArrayDeque<>(); 
        while(!bridge.isEmpty() || !trucks.isEmpty()) {

            time++; 
            int tmpWeight = 0; 
            int tmpTruckCnt = bridge.size(); 
            for(int i = 0; i < tmpTruckCnt; i++) {
                int[] truckOnBridge = bridge.poll();  
                if(truckOnBridge[1] + 1 == w) continue; // 다리에서 나간 트럭
                tmpWeight += truckOnBridge[0]; // 하중 체크 
                truckOnBridge[1]++; 
                bridge.offer(truckOnBridge); 
            }
            
            if(trucks.isEmpty()) continue; 
            if(tmpWeight + trucks.peek() <= L) {
                int truckWeight = trucks.poll(); 
                bridge.offer(new int[] {truckWeight, 0}); 
                tmpWeight += truckWeight; 
            } 
        }
        
        return time; 
    }
}