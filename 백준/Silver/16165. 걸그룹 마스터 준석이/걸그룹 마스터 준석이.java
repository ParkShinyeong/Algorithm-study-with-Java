import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        Map<String, String[]> groups = new HashMap<>(); 
        Map<String, String> nameAndGroup = new HashMap<>(); 
        
        for(int i = 0; i < N; i++) {
            String group = br.readLine(); 
            int num = Integer.parseInt(br.readLine()); 
            groups.put(group, new String[num]); 

            for(int j = 0; j < num; j++) {
                String name = br.readLine(); 
                groups.get(group)[j] = name; 
                nameAndGroup.put(name, group); 
            } 

            Arrays.sort(groups.get(group)); 
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine(); 
            int question = Integer.parseInt(br.readLine()); 
            if(question == 0) {
                for(String name: groups.get(input)) {
                    bw.write(name + "\n"); 
                }
            } else {
                bw.write(nameAndGroup.get(input) + "\n"); 
            }
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}