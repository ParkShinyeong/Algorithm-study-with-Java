import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int Q = Integer.parseInt(st.nextToken()); 
        
        TreeSet<Integer> sights = new TreeSet<>(); 
        st = new StringTokenizer(br.readLine()); 
        for(int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken()); 
            if(input == 1) sights.add(i); 
        }

        int tmpDohyeonPos = 1; 
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine()); 
            int query = Integer.parseInt(st.nextToken()); 
            switch(query) {
                case 1:
                    int point = Integer.parseInt(st.nextToken()); 
                    if(sights.contains(point)) sights.remove(point); 
                    else sights.add(point); 
                    break; 
                case 2:
                    int move = Integer.parseInt(st.nextToken()); 
                    tmpDohyeonPos = (tmpDohyeonPos + move) % N; 
                    tmpDohyeonPos = tmpDohyeonPos == 0 ? N : tmpDohyeonPos; 
                    break; 
                case 3:
                    Integer sight = sights.ceiling(tmpDohyeonPos);
                    if(sight == null) {
                        if(sights.isEmpty()) bw.write("-1\n"); 
                        else {
                            sight = sights.first(); 
                            bw.write(sight + N - tmpDohyeonPos + "\n"); 
                        }
                    }
                    else {
                        bw.write(sight - tmpDohyeonPos + "\n"); 
                    } 
                    break; 
            }
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}