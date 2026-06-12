import java.util.*; 
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length; 
        int[] elementss = new int[len * 2];
        for(int i = 0; i < len; i++) {
            elementss[i] = elementss[i + len] = elements[i]; 
        }
        
        int[][] dp = new int[len][len]; 
        Set<Integer> set = new HashSet<>(); 
        
        for(int i = 0; i < len; i++) {
            dp[i][0] = elements[i]; 
            set.add(dp[i][0]);
            for(int j = 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] + elementss[i + j];
                set.add(dp[i][j]); 
            }
        }
        
        return set.size();
    }
}