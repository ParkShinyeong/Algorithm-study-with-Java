import java.io.*;
import java.util.BitSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 
        String str = br.readLine(); 
        
        bw.write(solution(N, M, str) + "");
        bw.flush();
        bw.close();
        br.close();
	}
	
	static int solution(int N, int M, String str) {
		int lt = 1; 
		int pattern = 0; 
		int cnt = 0; 
		while(lt < M - 1) {
			if(str.charAt(lt - 1) == 'I' && str.charAt(lt) == 'O' && str.charAt(lt + 1) == 'I') {
				pattern++; 
				if(pattern == N) {
					cnt++; 
					pattern--; 
				}
				lt += 2; 
			} else {
				lt += 1; 
				pattern = 0; 
			}
		}
		return cnt; 
	}
}
