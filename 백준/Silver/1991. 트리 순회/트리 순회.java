import java.io.*;
import java.util.*;
class Node {
	char data; 
	Node leftChild; 
	Node rightChild; 
	
	Node(char data) {
		this.data = data; 
		this.leftChild = null; 
		this.rightChild = null; 
	}
	
	void setLeftChild(Node leftchild) {
		leftChild = leftchild;  
	}
	
	void setRightChild(Node rightchild) {
		rightChild = rightchild; 
	}
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st; 
        HashMap<Character, Node> tree = new HashMap<Character, Node>(); 
        
        int N = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	char parent = st.nextToken().charAt(0); 
        	char c1 = st.nextToken().charAt(0);
        	char c2 = st.nextToken().charAt(0);
        	
        	if(!tree.containsKey(parent)) {
        		tree.put(parent, new Node(parent)); 
        	}
        	if(c1 != '.') {
        		if(!tree.containsKey(c1)) {
        			Node child1 = new Node(c1); 
        			tree.put(c1, child1); 
        		}
        		tree.get(parent).setLeftChild(tree.get(c1));
        	}
        	if(c2 != '.') {
        		if(!tree.containsKey(c2)) {
        			Node child2 = new Node(c2); 
        			tree.put(c2, child2); 
        		}
        		tree.get(parent).setRightChild(tree.get(c2));
        	}
        }
        searchFirst(tree.get('A')); 
        searchMiddle(tree.get('A')); 
        searchLast(tree.get('A')); 
        bw.write(sb1.append("\n").toString());
        bw.write(sb2.append("\n").toString());
        bw.write(sb3.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 전위 순회 
    static StringBuilder sb1 = new StringBuilder(); 
    static void searchFirst(Node node) {
    	if(node == null) return; 
    	sb1.append(node.data); 
    	searchFirst(node.leftChild); 
    	searchFirst(node.rightChild); 
    }
    
    // 중위 순회 
    static StringBuilder sb2 = new StringBuilder(); 
    static void searchMiddle(Node node) {
    	if(node == null) return; 
    	searchMiddle(node.leftChild); 
    	sb2.append(node.data);  
    	searchMiddle(node.rightChild); 
    }
    
    // 후위 순회 
    static StringBuilder sb3 = new StringBuilder(); 
    static void searchLast(Node node) {
    	if(node == null) return; 
    	searchLast(node.leftChild); 
    	searchLast(node.rightChild); 
    	sb3.append(node.data);  
    }
}
