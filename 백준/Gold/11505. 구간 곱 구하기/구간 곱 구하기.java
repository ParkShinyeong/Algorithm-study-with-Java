import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static long[] arr; 
	static long[] Tree; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());  
		int K = Integer.parseInt(st.nextToken()); 
		
		arr = new long[N]; 
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine()); 
		}
		build(); 
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken()); 
			long b = Long.parseLong(st.nextToken()); 
			long c = Long.parseLong(st.nextToken()); 
			switch(a) {
			case 1: 
				update(b-1, c); 
				break; 
			case 2: 
				long ans = getSubset(b-1, c-1); 
				bw.write(ans + "\n");
				break; 
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void build() {
		Tree = new long[N * 4];
		buildRec(1, 0, N - 1); 
	}
	
	static long buildRec(int node, int nodeLeft, int nodeRight) {
		if(nodeLeft == nodeRight) {
			return Tree[node] = arr[nodeLeft]; 
		}
		int mid = (nodeLeft + nodeRight) / 2;  
		long leftVal = buildRec(node * 2, nodeLeft, mid); 
		long rightVal = buildRec(node*2 + 1, mid+1, nodeRight); 
		return Tree[node] = multiply(leftVal, rightVal); 
		
	}
	static void update(long idx, long newValue) {
		updateRec(idx, newValue, 1, 0, N - 1);
	}
	static long updateRec(long idx, long newValue, int node, int nodeLeft, int nodeRight) {
		if(idx < nodeLeft || idx > nodeRight) { 
			return Tree[node]; 
		}
		
		if(nodeLeft == nodeRight) {
			return Tree[node] = newValue; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		long leftVal = updateRec(idx, newValue, node*2, nodeLeft, mid); 
		long rightVal = updateRec(idx, newValue, node*2+1, mid+1, nodeRight); 
		return Tree[node] = multiply(leftVal, rightVal);
		
	}
	static long getSubset(long a, long b) {
		
		return getSubsetRec(a, b, 1, 0, N-1); 
	}

	private static long getSubsetRec(long a, long b, int node, int nodeLeft, int nodeRight) {
		if(a > nodeRight || b < nodeLeft) {
			return 1; 
		}
		if(a <= nodeLeft && nodeRight <= b) {
			return Tree[node]; 
		}
		int mid = (nodeLeft + nodeRight) / 2; 
		long leftVal = getSubsetRec(a, b, node*2, nodeLeft, mid); 
		long rightVal = getSubsetRec(a, b, node*2+1, mid+1, nodeRight); 
		return multiply(leftVal, rightVal); 	
	}
	
	static long multiply(long a, long b) {
		return (a * b) % 1000000007; 
	}
}
