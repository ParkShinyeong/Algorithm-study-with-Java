import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); 
        for(int t = 0; t < T; t++) {
            LinkedList<Character> list = new LinkedList<>(); 
            ListIterator<Character> iter = list.listIterator();

            String input = br.readLine(); 
            for(char c: input.toCharArray()) {
                if(c == '<') {
                    if(iter.hasPrevious()) iter.previous(); 

                } else if(c == '>') {
                    if(iter.hasNext()) iter.next(); 

                } else if(c == '-') {
                    if(iter.hasPrevious()) {
                        iter.previous(); 
                        iter.remove();
                    }
                } else {
                    iter.add(c); 
                }
            }
            while(iter.hasPrevious()) iter.previous(); 
    
            while(iter.hasNext()) {
                bw.write(iter.next()); 
            }
            bw.write("\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
