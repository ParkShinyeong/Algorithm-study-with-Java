import java.io.*;
import java.util.*;

public class Main {
	static int A; 
	static int B; 
	static int targetA; 
	static int targetB; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        A = Integer.parseInt(st.nextToken()); 
        B = Integer.parseInt(st.nextToken()); 
        targetA = Integer.parseInt(st.nextToken()); 
        targetB = Integer.parseInt(st.nextToken()); 
        int answer = 0; 
        if(targetA == 0 && targetB == 0) {
        	bw.write(answer + ""); 
            bw.flush();
        	return; 
        }; 
        answer = bfs(); 
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
	}
	
	static int bfs() {
		int[] bucket = {0, 0}; 
		Queue<int[]> q = new ArrayDeque<>(); 
		int a = 0, b = 0; 
//		HashSet<String> visit = new HashSet<>(); 
		boolean[][] visit = new boolean[A + 1][B + 1]; 
		visit[0][0] = true; 
		q.offer(bucket); 
		boolean flag = false; 
		int cnt = 0; 
		while(!q.isEmpty()) {
			int qSize = q.size(); 
			if(flag) break; 
			for(int i = 0; i < qSize; i++) {
				int[] tmpBucket = q.poll(); 
				a = tmpBucket[0]; 
				b = tmpBucket[1]; 
				
				int[] fillA = fillBucket(a, b, 0); 
				if(fillA[0] == targetA && fillA[1] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[fillA[0]][fillA[1]]){
					visit[fillA[0]][fillA[1]] = true; 
					q.offer(fillA); 
				}
				int[] fillB  = fillBucket(a, b, 1); 
				if(fillB[0] == targetA && fillB[1] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[fillB[0]][fillB[1]]){
					visit[fillB[0]][fillB[1]] = true; 
					q.offer(fillB); 
				}
				int[] emptyA = EmptyBucket(a, b, 0); 
				if(emptyA[0] == targetA && emptyA[1] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[emptyA[0]][emptyA[1]]){
					visit[emptyA[0]][emptyA[1]] = true; 
					q.offer(emptyA); 
				}
				int[] emptyB = EmptyBucket(a, b, 1); 
				if(emptyB[0] == targetA && emptyB[1] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[emptyB[0]][emptyB[1]]){
					visit[emptyB[0]][emptyB[1]] = true; 
					q.offer(emptyB); 
				}
				int[] moveAtoB = MoveBucket(a, b, A, B); 
				if(moveAtoB[0] == targetA && moveAtoB[1] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[moveAtoB[0]][moveAtoB[1]]){
					visit[moveAtoB[0]][moveAtoB[1]] = true; 
					q.offer(moveAtoB); 
				}
				int[] moveBtoA = MoveBucket(b, a, B, A); 
				if(moveBtoA[1] == targetA && moveBtoA[0] == targetB) {
					flag = true; 
					break; 
				} else if(!visit[moveBtoA[1]][moveBtoA[0]]){
					visit[moveBtoA[1]][moveBtoA[0]] = true;  
					q.offer(new int[] {moveBtoA[1], moveBtoA[0]}); 
				}
			}
			cnt++; 
		}
		if(!flag) return -1; 
		return cnt; 
	}
	
	static int[] fillBucket(int a, int b, int pos) {
		if(pos == 0) {
			return new int[] { A, b }; 
		} else {
			return new int[] { a, B }; 
		}
	}
	
	static int[] EmptyBucket(int a, int b, int pos) {
		if(pos == 0) {
			return new int[] { 0, b }; 
		} else {
			return new int[] { a, 0 }; 
		} 
	}
	
	static int[] MoveBucket(int x, int y, int volx, int voly ) {
		// x에 남아 있는 물의 양이 y에 남아있는 빈 공간보다 적거나 같다면 => 물통 x의 물을 y에 다 붓는다. 
		int remaining = voly - y; 
		if(remaining >= x) {
			return new int[] { 0, y + x }; 
		}
		// x에 남아 있는 물의 양이 물통 y에 남아있는 빈공간보다 많다 => 부을 수 있는 만큼 최대로 부어 y를 꽉 채우고, 나머지는 물통 x에 남긴다. 
		else {
			return new int[] {x - remaining, voly}; 
		}
	}
}
