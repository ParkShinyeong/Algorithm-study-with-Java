import java.util.*; 
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int[] visit = new int[cards.length]; 
        int box = 1, tmp = 0; 
        int total = 0; 
        ArrayList<Integer> counts = new ArrayList<>(); 
        
        while(total < cards.length) {
            int cnt = 0; 
            while(visit[tmp] == 0) {
                visit[tmp] = box;
                tmp = cards[tmp] - 1; 
                cnt++; 
                total++; 
            }
            counts.add(cnt); 
            box++; 
            
            for(int i = 0; i < cards.length; i++) {
                if(visit[i] == 0) {
                    tmp = i; 
                    break; 
                }
            }
        }
        
        Collections.sort(counts, (a, b) -> b - a); 
        if(counts.size() < 2) return 0; 
        return counts.get(0) * counts.get(1);
    }
}