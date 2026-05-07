class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder nums = new StringBuilder(); 
        
        int tmpnum = 0; 
        nums.append("-"); 
        while(nums.length() <= m * t) {
            nums.append(Integer.toString(tmpnum++, n).toUpperCase()); 
        }
        
        String num = nums.toString();
        for(int i = 0; i < t; i++) {
            answer.append(num.charAt(p + m * i)); 
        }
        
        return answer.toString();
    }
}