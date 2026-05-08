import java.util.*; 
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorCnt = getDivisorCnt(e); 
        int[] maxValues = getMaxValue(divisorCnt); 
    
        for(int i = 0; i < starts.length; i++) {
            int start = starts[i]; 
            answer[i] = maxValues[start]; 
        }
        return answer;
    }
    
    private int[] getDivisorCnt(int max) {
        
        int[] divisorCnt = new int[max + 1];
        divisorCnt[1] = 1; 
        
        for(int i = 2; i <= max; i++) {
            for(int j = i; j <= max; j += i) {
                divisorCnt[j]++; 
            }
        }
        return divisorCnt; 
    }
    
    private int[] getMaxValue(int[] divisorCnt) {
        int len = divisorCnt.length;
        int max = divisorCnt[len - 1]; 
        
        int[] dp = new int[len]; 
        dp[len - 1] = len - 1; 
        
        for(int i = len - 2; i > 0; i--) {
            if(divisorCnt[i] >= max) {
                dp[i] = i; 
                max = divisorCnt[i]; 
            } else {
                dp[i] = dp[i + 1]; 
            }
        }
        return dp; 
    }
}