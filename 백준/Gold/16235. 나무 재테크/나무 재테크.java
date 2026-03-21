import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K; 
    static int[][] land; 
    static int[][] A; 
    static ArrayDeque<Tree> trees; 
    static ArrayDeque<Tree> deadTrees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        land = new int[N + 1][N + 1]; 
        A = new int[N + 1][N + 1]; 

        for(int i = 1; i <= N; i++) {
            Arrays.fill(land[i], 5); 
        }
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        ArrayList<Tree> initial = new ArrayList<>(); 
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 
            int age = Integer.parseInt(st.nextToken()); 
            initial.add(new Tree(age, x, y)); 
        }
        
        trees = new ArrayDeque<>(); 
        deadTrees = new ArrayDeque<>(); 

        Collections.sort(initial); 
        for(Tree tree: initial) {
            trees.offer(tree); 
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        for(int i = 1; i <= K; i++) {
            spring(); 
            summer(); 
            fall(); 
            winter(); 
        }
        return trees.size(); 
    }

    private static void spring() {
        int size = trees.size(); 
        for(int i = 0; i < size; i++) {
            Tree tmp = trees.poll(); 
            if(land[tmp.x][tmp.y] < tmp.age) {
                deadTrees.offer(tmp); // 양분 부족
                continue; 
            } 
            land[tmp.x][tmp.y] -= tmp.age; 
            tmp.age++; 
            trees.offer(tmp); 
        }
    }

    private static void summer() {
        while(!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll(); 
            land[tree.x][tree.y] += (tree.age / 2); 
        }
    }
    
    private static void fall() {
        int[] dirx = {0, 0, 1, -1, 1, 1, -1, -1}; 
        int[] diry = {1, -1, 0, 0, 1, -1, 1, -1}; 
        int size = trees.size(); 
        ArrayList<Tree> newTrees = new ArrayList<>(); 
        for(int i = 0; i < size; i++) {
            Tree tree = trees.poll(); 
            if(tree.age % 5 != 0) {
                trees.add(tree); 
                continue; 
            }
            for(int d = 0; d < 8; d++) {
                int nx = tree.x + dirx[d]; 
                int ny = tree.y + diry[d]; 
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue; 
                newTrees.add(new Tree(1, nx, ny)); 
            }
            trees.add(tree); 
        }

        for(Tree tree: newTrees) {
            trees.addFirst(tree); 
        }
    }

    private static void winter() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                land[i][j] += A[i][j]; 
            }
        }
    }
}

class Tree implements Comparable<Tree> {
    int age; 
    int x, y; 

    Tree(int age, int x, int y) {
        this.age = age; 
        this.x = x; 
        this.y = y; 
    }
    @Override
    public int compareTo(Tree tree) {
        return this.age - tree.age; 
    }
}