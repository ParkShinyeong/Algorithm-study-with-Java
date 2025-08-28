import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); 
		int[] arr = new int[n]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		int m = Integer.parseInt(br.readLine()); 
		Arrays.sort(arr);
		int lt = 0, rt = n - 1; 
		int ans = 0; 
		while(lt < rt) {
			if(arr[lt] + arr[rt] == m) {
				ans++; 
				lt++; 
				rt--; 
			} else if(arr[lt] + arr[rt] < m) {
				lt++; 
			} else {
				rt--; 
			}
		}
		bw.write(ans+ "");
		bw.flush(); 
		bw.close();
		br.close();
	}
}
