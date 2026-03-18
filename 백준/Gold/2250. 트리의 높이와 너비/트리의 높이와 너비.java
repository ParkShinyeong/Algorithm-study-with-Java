import java.io.*;
import java.util.*;

public class Main {
    static int N, max, maxLevel; 
    static int count = 1; 
    static int[] parents; 
    static Node[] trees; 
    static Node root; 
    static int[] minPos, maxPos; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        trees = new Node[N + 1]; 
        minPos = new int[N + 1]; 
        maxPos = new int[N + 1]; 
        parents = new int[N + 1]; 
        Arrays.fill(minPos, 10001); 
        
        for(int i = 1; i <= N; i++) {
            trees[i] = new Node(i); 
        }

        StringTokenizer st; 
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); 

            int p = Integer.parseInt(st.nextToken()); 
            int l = Integer.parseInt(st.nextToken()); 
            int r = Integer.parseInt(st.nextToken()); 
            
            if(l != -1) {
                parents[l] = p; 
                trees[p].left = trees[l]; 
            }
            if(r != -1) {
                parents[r] = p; 
                trees[p].right = trees[r]; 
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(parents[i] == 0) {
                root = trees[i]; 
                break; 
            }
        }
        solution(); 
        bw.write(maxLevel + " " + max); 

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void solution() {
        max = 0; 
        maxLevel = 0; 
        dfs(root, 1); 
        for(int i = 1; i <= N; i++) {
            int len = maxPos[i] - minPos[i] + 1; 
            if(max < len) {
                max = len; 
                maxLevel = i; 
            }
        }
    }

    private static void dfs(Node node, int level) {
        if(node == null) return; 

        dfs(node.left, level + 1); 
        if(minPos[level] > count) minPos[level] = count; 
        if(maxPos[level] < count) maxPos[level] = count; 
        count++; 
        dfs(node.right, level + 1); 
        
    }
}

class Node {
    int value; 
    Node left; 
    Node right; 
    Node(int value) {
        this.value = value; 
    }
}