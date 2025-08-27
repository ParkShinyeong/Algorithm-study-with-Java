import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        Queue<Integer> output = new ArrayDeque<>(); 
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < M; i++) {
            output.offer(Integer.parseInt(st.nextToken()));
        }
        
        LinkedList<Integer> queue = new LinkedList<>(); 
        for(int i = 1; i <= N; i++) {
            queue.add(i); 
        }
        
        int cnt = 0; 
        while(!output.isEmpty()) {
            int num = output.poll(); 
            while(true) {
                if(queue.get(0) == num) {
                    queue.remove(0); 
                    break; 
                } else if(queue.indexOf(num) <= (queue.size() / 2)) {
                    int first = queue.removeFirst(); 
                    queue.addLast(first); 
                    cnt++; 
                } else {
                    int last = queue.removeLast(); 
                    queue.addFirst(last);
                    cnt++; 
                }
            }
        }

        bw.write(cnt + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}