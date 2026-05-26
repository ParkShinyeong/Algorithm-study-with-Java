import java.util.*; 
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s); 
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 
        
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken()); 
            min = Math.min(n, min); 
            max = Math.max(n, max); 
        }
        
        return min + " " + max;
    }
}