import java.util.*; 
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][4]; 
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i]; 
        }
        
       for(int i = 1; i < land.length; i++) {
           for(int x = 0; x < 4; x++) {
               int max = getMax(dp[i - 1], x); 
               dp[i][x] = max + land[i][x]; 
           }
       }

        return getMax(dp[dp.length - 1], -1);
    }
    
    private int getMax(int[] arr, int prevIdx) {
        int max = 0; 
        for(int i = 0; i < arr.length; i++) {
            if(i == prevIdx) continue; 
            max = Math.max(max, arr[i]); 
        }
        return max; 
    }
}