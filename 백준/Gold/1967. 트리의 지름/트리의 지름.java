import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static ArrayList<Node>[] tree; 
    static int max = 0;
    static int maxLeaf = 0;  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        tree = new ArrayList[N + 1]; 

        for(int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>(); 
        }

        StringTokenizer st; 
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            int weight = Integer.parseInt(st.nextToken()); 

            Node node1 = new Node(n1, weight); 
            Node node2 = new Node(n2, weight); 
            tree[n1].add(node2); 
            tree[n2].add(node1); 
        }

        dfs(1, 0, 0); 
        int leaf = maxLeaf; 
        dfs(leaf, 0, 0); 
        bw.write(max + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int node, int parent, int length) {
        int childNodeCount = 0; 
        for(Node nxt: tree[node]) {
            if(nxt.value == parent) continue; 
            childNodeCount++; 
        }

        if(childNodeCount == 0) {
            if(max < length) {
                max = length; 
                maxLeaf = node; 
            }
            return; 
        } 

        for(Node nxt: tree[node]) {
            if(nxt.value == parent) continue;
            dfs(nxt.value, node, length + nxt.weight); 
        }

    }
}

class Node {
    int value, weight; 
    Node(int value, int weight) {
        this.value = value; 
        this.weight = weight; 
    }
}