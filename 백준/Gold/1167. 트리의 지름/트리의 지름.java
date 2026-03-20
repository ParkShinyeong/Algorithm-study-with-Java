import java.io.*;
import java.util.*;

public class Main {
    static int N, max, maxLeaf; 
    static ArrayList<Node>[] tree; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1]; 
        
        for(int i= 0; i<= N; i++) {
            tree[i] = new ArrayList<>(); 
        }
        StringTokenizer st; 
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int v1 = Integer.parseInt(st.nextToken());
            while(true) {
                int v2 = Integer.parseInt(st.nextToken());
                if(v2 == -1) break; 

                int w = Integer.parseInt(st.nextToken());
                tree[v1].add(new Node(v2, w)); 
            }
        }

        dfs(1, 0, 0); 
        dfs(maxLeaf, 0, 0);
        
        bw.write(max + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void dfs(int node, int parent, int length) {
        boolean isLeaf = true; 

        for(Node nxt: tree[node]) {
            if(nxt.value == parent) continue; 
            isLeaf = false; 
            dfs(nxt.value, node, length + nxt.weight); 
        }

        if(isLeaf) {
            if(max < length) {
                max = length; 
                maxLeaf = node; 
            }
            return; 
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