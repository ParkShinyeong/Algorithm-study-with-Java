import java.io.*; 
import java.util.*;

// 1654번 랜선 자르기 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		String[] input = br.readLine().split(" "); 
		int k = Integer.parseInt(input[0]); 
		int n = Integer.parseInt(input[1]);
		
		int[] arr = new int[k]; 
		long max = 0; 
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
			if(arr[i] > max) max = arr[i]; 
		}
		
		long answer = solution(k, n, arr, max + 1); 
		bw.write(answer + "");
		bw.flush();
		br.close();
		bw.close(); 
	}
	
	public static long solution(int k, int n, int[] arr, long max) {
		long min = 0; 
		long mid = 0; 
		
		while(min < max) {
			mid = (max + min) / 2; 
			long count = 0; 
			
			for(int i = 0; i < k; i++) {
				count += (arr[i] / mid); 
			}
			
			if(count < n) {
				max = mid; 
			} else {
				min = mid + 1; 
			}
		}
		
		return min - 1; 
	}
}