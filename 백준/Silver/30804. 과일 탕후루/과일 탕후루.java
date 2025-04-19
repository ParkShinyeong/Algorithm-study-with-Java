import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; 
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());  
        }
        int ans = solution(N, arr); 
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
	}
	
	static int solution(int N, int[] arr) {
		int lt = 0; 
		int max = 0; 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for(int rt = 0; rt < N; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1); 
			if(map.size() <= 2) {
				max = Math.max(max, rt - lt + 1); 
			} else {
				while(map.size() > 2) {
					map.put(arr[lt], map.get(arr[lt]) - 1); 
					if(map.get(arr[lt]) == 0) map.remove(arr[lt]); 
					lt++; 
				}
			}
		}
		return max; 
	}
}
