import java.io.*;
import java.util.*;
class Main {

    static int front, rear; 
    static int[] queue; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine());

        queue = new int[2_000_001]; 
        front = 0; 
        rear = 0; 
        StringTokenizer st; 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            switch(st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken()); 
                    push(x); 
                    break; 
                case "pop":
                    bw.write(pop() + "\n"); 
                    break; 
                case "size":
                    bw.write(size() + "\n"); 
                    break; 
                case "empty": 
                    bw.write(empty() + "\n"); 
                    break; 
                case "front":
                    bw.write(front() + "\n"); 
                    break; 
                case "back":
                    bw.write(back() + "\n"); 
                    break; 
            }
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
    
    public static void push(int x) {
        queue[rear++] = x; 
    }

    public static int pop() {
        if(front == rear) return -1; 
        int pop = queue[front++]; 
        return pop; 
    }

    public static int size() {
        return rear - front; 
    }
    
    public static int empty() {
        return front == rear ? 1 : 0; 
    }

    public static int front() {
        return front == rear ? -1 : queue[front]; 
    }

    public static int back() {
        return front == rear ? -1 : queue[rear - 1]; 
    }
}