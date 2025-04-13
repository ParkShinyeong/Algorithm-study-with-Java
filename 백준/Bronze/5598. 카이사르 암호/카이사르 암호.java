import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String input = br.readLine(); 
        int n = 3; 
        StringBuilder sb = new StringBuilder(); 
        for(char c: input.toCharArray()) {
        	if(c - 3 < 65) sb.append((char)(c - 3 + 26)); 
        	else sb.append((char)(c - 3)); 
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}
