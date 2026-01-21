import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken()); 

        Map<Integer, Integer> count = new HashMap<>(); 
        Map<Integer, Integer> idxMap = new HashMap<>(); 
        
        st = new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken()); 
            if(count.get(input) == null) idxMap.put(input, i); 
            count.put(input, count.getOrDefault(input, 0) + 1); 
        }
        StringBuilder sb = new StringBuilder(); 
        count.entrySet().stream()
        .sorted(Map.Entry.comparingByKey((a, b) -> {
            if(count.get(a).equals(count.get(b))) return idxMap.get(a).compareTo(idxMap.get(b)); 
            return count.get(b).compareTo(count.get(a)); 
        }))
        .forEach(entry -> {
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" "); 
            }
        }); 

        bw.write(sb.toString());
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}