import java.util.*; 
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] n1 = {1, 2, 3, 4, 5}; 
        int[] n2 = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] n3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        int max = 0; 
        int[] scores = new int[3]; 
        
        for(int i = 0; i < answers.length; i++) {
            if(n1[i % 5] == answers[i]) {
                max = Math.max(max, ++scores[0]); 
            }
            if(n2[i % 8] == answers[i]) {
                max = Math.max(max, ++scores[1]); 
            }
            if(n3[i % 10] == answers[i]) {
                max = Math.max(max, ++scores[2]); 
            }
        }
        
        for(int i = 0; i < 3; i++) {
            if(max== scores[i]) answer.add(i + 1); 
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}