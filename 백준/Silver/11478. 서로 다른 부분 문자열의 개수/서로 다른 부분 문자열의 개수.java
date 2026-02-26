import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine(); 
        HashMap<String, Integer> count = new HashMap<>(); 

        for(int i = 0; i < input.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(input.charAt(i)); 

            for(int j = i + 1; j < input.length(); j++) {
                String tmp = sb.toString(); 
                count.put(tmp, count.getOrDefault(tmp, 0) + 1); 
                sb.append(input.charAt(j));
            }
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1); 
        }

        bw.write(count.keySet().size() + ""); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}