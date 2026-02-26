import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int K = Integer.parseInt(st.nextToken()); 
        int L = Integer.parseInt(st.nextToken()); 

        Map<String, Integer> waitingroom = new HashMap<>(); 

        for(int i = 1; i <= L; i++) {
            waitingroom.put(br.readLine(), i); 
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(waitingroom.entrySet()); 
        Collections.sort(entryList, (a, b) -> a.getValue().compareTo(b.getValue())); 

        int totalK = entryList.size() > K ? K : entryList.size();
        for(int i = 0; i < totalK; i++) {
            bw.write(entryList.get(i).getKey() + "\n"); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}