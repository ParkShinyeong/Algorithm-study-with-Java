import java.io.*;
import java.util.*;

public class Main {
    static int N, K; 
    static PriorityQueue<Gem> gemsOrderbyPrice; 
    static PriorityQueue<Gem> gemsOrderbyWeight; 
    static int[] bags; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        gemsOrderbyPrice = new PriorityQueue<>((a, b) -> {
            return b.price - a.price; 
        }); 
        gemsOrderbyWeight = new PriorityQueue<>((a, b) -> {
            if(a.weight == b.weight) {
                return b.price - a.price; 
            } 
            return a.weight - b.weight; 
        }); 

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int w = Integer.parseInt(st.nextToken()); 
            int p = Integer.parseInt(st.nextToken()); 
            gemsOrderbyWeight.offer(new Gem(w, p));
        }

        bags = new int[K]; 
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine()); 
        }
        Arrays.sort(bags);
        
        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static long solution() {
        long total = 0; 

        for(int w: bags) {
            while(!gemsOrderbyWeight.isEmpty() && gemsOrderbyWeight.peek().weight <= w){
                gemsOrderbyPrice.offer(gemsOrderbyWeight.poll());
            }

            if(!gemsOrderbyPrice.isEmpty()) {
                total += gemsOrderbyPrice.poll().price; 
            }
        }
    
        return total; 
    }
}

class Gem {
    int weight, price; 
    Gem(int weight, int price) {
        this.weight = weight; 
        this.price = price; 
    }

}