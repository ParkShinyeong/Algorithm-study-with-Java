import java.util.*; 
class Solution {
    Set<Integer> primeNumList = new HashSet<>(); 
    int max = 0; 
    boolean[] isNotPrime = new boolean[9_999_999];
    
    public int solution(String numbers) {
        int answer = 0;
        dfs(0, "0", numbers, new boolean[numbers.length()]); 
        answer = primeNumList.size(); 
        
        return answer;
    }
    
    public void dfs(int depth, String num, String numbers, boolean[] visited) {
        int intNum = Integer.valueOf(num); 
        if(isPrimeNumber(intNum)) {
            primeNumList.add(intNum); 
        }
        
        if(depth >= numbers.length()) {
            return; 
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue; 
            visited[i] = true; 
            dfs(depth + 1, num + numbers.charAt(i), numbers, visited); 
            visited[i] = false; 
        }
    }
    
    public boolean isPrimeNumber(int num) { 
        if (num <= 1) return false; 
        if(num <= max) {
            return !isNotPrime[num]; 
        }
        
        max = num; 
        
        for(int i = 2; i * i <= num; i++) {
            if(!isNotPrime[i]) {
                for(int j = i * i; j <= num; j += i) {
                    isNotPrime[j] = true; 
                }
            }
        }
        
        return !isNotPrime[num]; 
    }
}