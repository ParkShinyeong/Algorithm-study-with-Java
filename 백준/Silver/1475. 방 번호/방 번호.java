import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Integer input = Integer.parseInt(br.readLine()); 
		int[] set = new int[10];
		while(input > 0) {
			int tmp = input % 10;  
			if(tmp == 6 || tmp == 9) {
				set[6] += 1; 
			} else {
				set[tmp] += 1; 
			}
			input /= 10; 
		}
		int ans = 0; 
		for(int i = 0; i < 9; i++) {
			if(i == 6) ans = Math.max(ans, (int)Math.ceil(set[i] / 2.0));
			else {
				ans = Math.max(ans, set[i]); 			
			}
		}
		bw.write(ans + "");
		bw.flush(); 
		bw.close();
		br.close();
	}
}
