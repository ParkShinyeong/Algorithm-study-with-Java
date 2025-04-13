import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        
        int[] minTree = new int[4 * n]; 
        int[] maxTree = new int[4 * n]; 
        int[] arr = new int[n + 1]; 
        
        for(int i = 1; i <= n; i++) {
        	arr[i] = Integer.parseInt(br.readLine()); 
        }
        
        buildMinTreeRec(arr, minTree, 1, 1, n); 
        buildMaxTreeRec(arr, maxTree, 1, 1, n); 
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine()); 
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int min = findMin(minTree, 1, 1, n, from, to); 
        	int max = findMax(maxTree, 1, 1, n, from, to); 
        	bw.write(min + " " + max + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static int buildMinTreeRec(int[] arr, int[] minTree, int node, int nodeLeft, int nodeRight) {
		if(nodeLeft == nodeRight) {
			return minTree[node] = arr[nodeLeft]; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		int leftVal = buildMinTreeRec(arr, minTree, node * 2, nodeLeft, mid); 
		int rightVal = buildMinTreeRec(arr, minTree, node * 2 + 1, mid + 1, nodeRight); 
		
		
		return minTree[node] = Math.min(leftVal, rightVal); 
		
	}
	
	static int buildMaxTreeRec(int[] arr, int[] maxTree, int node, int nodeLeft, int nodeRight) {
		if(nodeLeft == nodeRight) {
			return maxTree[node] = arr[nodeLeft]; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		int leftVal = buildMaxTreeRec(arr, maxTree, node * 2, nodeLeft, mid); 
		int rightVal = buildMaxTreeRec(arr, maxTree, node * 2 + 1, mid + 1, nodeRight); 
		return maxTree[node] = Math.max(leftVal, rightVal);
	}
	
	static int findMin(int[] minTree, int node, int nodeLeft, int nodeRight, int from, int to) {
		if(from <= nodeLeft && nodeRight <= to) {
			return minTree[node]; 
		}
		
		if(nodeRight < from || nodeLeft > to) {
			return Integer.MAX_VALUE; 
		}

		int mid = (nodeLeft + nodeRight) / 2; 
		int leftVal = findMin(minTree, node*2, nodeLeft, mid, from, to); 
		int rightVal = findMin(minTree, node*2 + 1, mid + 1, nodeRight, from, to); 
		return Math.min(leftVal, rightVal); 
	}
	
	static int findMax(int[] maxTree, int node, int nodeLeft, int nodeRight, int from, int to) {
		if(from <= nodeLeft && nodeRight <= to) {
			return maxTree[node]; 
		}
		
		if(nodeRight < from || nodeLeft > to) {
			return 0; 
		}
		
		int mid = (nodeLeft + nodeRight) / 2; 
		int leftVal = findMax(maxTree, node*2, nodeLeft, mid, from, to); 
		int rightVal = findMax(maxTree, node*2 + 1, mid + 1, nodeRight, from, to); 
		int max = Math.max(leftVal, rightVal); 
		return max; 
	}
}
