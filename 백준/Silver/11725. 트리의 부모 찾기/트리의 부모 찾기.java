import java.io.*;
import java.util.*;
class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        N = Integer.parseInt(br.readLine()); 
        ArrayList<Integer>[] matrix = new ArrayList[N + 1]; 
        for(int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList<>(); 
        }
        StringTokenizer st; 
        for(int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken()); 
            int n2 = Integer.parseInt(st.nextToken()); 
            matrix[n1].add(n2); 
            matrix[n2].add(n1); 
        }
        
        int[] parents = solution(matrix);  
        for(int i = 2; i <= N; i++) {
            bw.write(parents[i] + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    public static int[] solution(ArrayList<Integer>[] matrix ) {
        int[] parents = new int[N + 1]; 
        parents[1] = -1; 
        Queue<Integer> q = new ArrayDeque<>(); 
        q.offer(1); 
        while(!q.isEmpty()) {
            int tmp = q.poll(); 
            for(int n: matrix[tmp]) {
                if(parents[n] != 0) continue; 
                parents[n] = tmp; 
                q.offer(n); 
            }
        }
        return parents; 
    }
}