class Solution {
    public int solution(int[][] sizes) {
        int upperMax = 0; 
        int lowerMax = 0; 
        
        for(int i = 0; i < sizes.length; i++) {
            upperMax = Math.max(upperMax, Math.max(sizes[i][0], sizes[i][1])); 
            lowerMax = Math.max (lowerMax, Math.min(sizes[i][0], sizes[i][1])); 
        }
        
        return upperMax * lowerMax;
    }
}