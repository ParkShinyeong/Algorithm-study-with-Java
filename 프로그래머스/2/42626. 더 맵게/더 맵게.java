import java.util.*; 
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]); 
        }
        
        while(!pq.isEmpty()) {
            int min = pq.poll(); 
            if(min >= K) break; 
            if(pq.size() == 0 && min < K) return -1; 
            
            answer++; 
            int secMin = pq.poll(); 
            pq.add(min + secMin*2); 
        }
        
        return answer;
    }
    
}