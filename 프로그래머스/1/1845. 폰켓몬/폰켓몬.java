import java.util.*; 
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = nums.length / 2; 
        Map<Integer, Integer> numCount = new HashMap<>(); 
        for(int num: nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1); 
        }
        
        if(numCount.size() > cnt) answer = cnt; 
        else answer = numCount.size(); 
        
        return answer;
    }
}