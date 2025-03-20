import java.io.*;
import java.util.*;
public class Main{
	static int N;
	static long[] arr; 
	static long[] Tree; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); // 수의 개수 
		int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수 
		int K = Integer.parseInt(st.nextToken()); // 구간 합 구하는 횟수
		
		arr = new long[N]; 
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine()); 
		}
		
		build(); // 트리 형성
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken()); 
			long b = Long.parseLong(st.nextToken()); 
			long c = Long.parseLong(st.nextToken()); 
			switch(a) {
			case 1: 
				// 수 변경 b번째 수를 c로 
				update(b-1, c); 
				break; 
			case 2: 
				// 구간합 b번째 수부터 c번째 수까지  
				long ans = getSubset(b-1, c-1); 
				bw.write(ans + "\n");
				break; 
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 세그먼트 트리 형성 
	static void build() {
		Tree = new long[N * 4];
		buildRec(1, 0, N - 1); 
	}
	
	static long buildRec(int node, int nodeLeft, int nodeRight) {
		if(nodeLeft == nodeRight) {
			return Tree[node] = arr[nodeLeft]; 
		}
		int mid = (nodeLeft + nodeRight) / 2; 
		return Tree[node] = buildRec(node * 2, nodeLeft, mid) + buildRec(node*2 + 1, mid+1, nodeRight); 
		
	}
	
	// 세그먼트 트리 수정 
	static void update(long idx, long newValue) {
		updateRec(idx, newValue, 1, 0, N - 1);
	}
	
	static long updateRec(long idx, long newValue, int node, int nodeLeft, int nodeRight) {
		if(idx < nodeLeft || idx > nodeRight) { // 변경이 필요 없는 노드 
			return Tree[node]; 
		}
		
		if(nodeLeft == nodeRight) {
			return Tree[node] = newValue; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		return Tree[node] = updateRec(idx, newValue, node*2, nodeLeft, mid) + updateRec(idx, newValue, node*2+1, mid+1, nodeRight); 
	}
	
	// 구간합 
	static long getSubset(long a, long b) {
		
		return getSubsetRec(a, b, 1, 0, N-1); 
	}

	private static long getSubsetRec(long a, long b, int node, int nodeLeft, int nodeRight) {
		if(a > nodeRight || b < nodeLeft) {
			return 0; 
		}
		
		if(a <= nodeLeft && nodeRight <= b) {
			return Tree[node]; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		return getSubsetRec(a, b, node*2, nodeLeft, mid) + getSubsetRec(a, b, node*2+1, mid+1, nodeRight); 	
	}
}
