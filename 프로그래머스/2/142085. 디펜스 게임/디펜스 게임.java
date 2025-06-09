import java.util.*; 

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        int soldier = n; 
        for(int i = 0; i < enemy.length; i++) {
            
            pq.offer(enemy[i]); 
            if(pq.size() > k) {
                int tmp = pq.poll(); 
                soldier -= tmp; 
                
            } 
            
            if(soldier < 0) break; 
            answer = i + 1;
        }
        
        
        return answer;
    }
}