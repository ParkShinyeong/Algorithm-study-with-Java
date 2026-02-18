import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 
        
        for(int i = 0; i < N; i++) {
        	arr[i] =  Integer.parseInt(br.readLine()); 
        }
        Arrays.sort(arr);
        ArrayList<Integer> sample = new ArrayList<Integer>(); 
        HashSet<Integer> set = new HashSet<Integer>(); 
        for(int i = 0; i < N; i++) {
        	for(int j = i; j < N; j++) {
        		set.add(arr[i] + arr[j]); 
        	}
        }
        int ans = solution(N, arr, set); 
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static int solution(int N, int[] arr, HashSet<Integer> set ) {
		for(int i = N-1; i >= 0; i--) {
        	for(int j = i; j >= 0; j--) {
        		if(set.contains(arr[i] - arr[j])) {
        			return arr[i]; 
        		}
        	}
        }
		return 0; 
	}
}

