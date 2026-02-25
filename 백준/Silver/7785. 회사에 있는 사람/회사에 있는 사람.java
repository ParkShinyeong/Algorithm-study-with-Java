import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 

        HashMap<String, Integer> workerLogs = new HashMap<>(); 
        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            String name = st.nextToken(); 
            String move = st.nextToken(); 

            if(move.equals("enter")) {
                workerLogs.put(name, 1); 
            } else {
                workerLogs.remove(name); 
            }
        }
        String[] names = workerLogs.keySet().toArray(new String[0]); 
        Arrays.sort(names, Collections.reverseOrder()); 
        for(String name: names) {
            bw.write(name + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}