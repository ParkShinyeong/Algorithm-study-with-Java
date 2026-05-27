class Solution {
    public int solution(int n) {
        int nCnt = getOneCount(n); 
        int nxt = n + 1; 
        
        while(true) {
            int nxtCnt = getOneCount(nxt); 
            if(nCnt == nxtCnt) return nxt; 
            nxt++; 
        }
    }
    
    private int getOneCount(int n) {
        String binaryN = Integer.toBinaryString(n); 
        
        int cnt = 0; 
        for(char c: binaryN.toCharArray()) {
            if(c == '1') cnt++; 
        }
        
        return cnt; 
        
    }
}