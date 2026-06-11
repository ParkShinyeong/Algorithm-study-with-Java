class Solution {
    int[] memo; 
    public int solution(int n) {
        memo = new int[n + 1]; 
        memo[1] = 1; 
        
        return fibo(n);
    }
    
    private int fibo(int n) {
        if(memo[n] > 0 || n <= 1) return memo[n]; 
        return memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567; 
        
    }
}