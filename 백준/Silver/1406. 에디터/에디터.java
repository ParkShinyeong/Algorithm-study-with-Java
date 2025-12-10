import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String str = br.readLine(); 
        LinkedList<Character> chars = new LinkedList<>(); 
        for(char c: str.toCharArray()) {
            chars.add( c);
        }
        ListIterator listIt = chars.listIterator(); 
        while(listIt.hasNext()) {
            listIt.next(); 
        }
        int M = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < M; i++) {
            String command = br.readLine(); 
            char c = command.charAt(0); 
            
            switch (c) {
                case 'L':
                    if(listIt.hasPrevious()) listIt.previous(); 
                    break; 
                case 'D':
                    if(listIt.hasNext()) listIt.next(); 
                    break; 
                case 'B': 
                    if(listIt.hasPrevious()) {
                        listIt.previous(); 
                        listIt.remove(); 
                    }
                    break;
                case 'P' :
                    char insert = command.charAt(2); 
                    listIt.add(insert); 
                    break;  
            }
        }
        for(char c: chars) {
            bw.write(c); 
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
