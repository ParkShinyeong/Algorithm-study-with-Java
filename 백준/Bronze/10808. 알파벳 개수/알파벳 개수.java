import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String input = br.readLine(); 
        int[] characters = new int[26]; 
        for(char c: input.toCharArray()) {
            characters[c - 'a']++; 
        }

        for(int i = 0; i < characters.length; i++) {
            bw.write(characters[i] + " "); 
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
