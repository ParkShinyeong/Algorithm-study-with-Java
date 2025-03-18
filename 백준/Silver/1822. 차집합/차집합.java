import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine()); 
		int A = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken()); 
		
		HashSet<Integer> hsA = new HashSet<>(); 
		HashSet<Integer> hsB = new HashSet<>(); 
		
		int[] arrA = new int[A]; 
		int[] arrB = new int[B]; 

		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < A; i++) {
			arrA[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < B; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int cnt = 0; 
		StringBuilder sb = new StringBuilder(); 
		for(int a: arrA) {
			if(Arrays.binarySearch(arrB, a) < 0) {
				cnt++; 
				sb.append(a).append(" "); 
			}
		}
		
		bw.write(cnt + "\n");
		if(cnt > 0) {
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
