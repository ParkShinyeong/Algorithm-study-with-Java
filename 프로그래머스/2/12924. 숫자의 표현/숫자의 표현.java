class Solution {
    public int solution(int n) {
        int answer = 0;
        int lt = 1; 
        int num = 0; 
        
        for(int rt = 1; rt <= n; rt++) {
            num += rt;
            
            while (num > n) {
                num -= lt++; 
            } 
            
            if(num == n) answer++;
            
        }
      
        return answer;
    }
}