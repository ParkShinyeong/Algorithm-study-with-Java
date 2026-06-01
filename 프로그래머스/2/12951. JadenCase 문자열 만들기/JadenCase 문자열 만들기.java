import java.util.*; 

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true; 
        s = s.toLowerCase(); 
        
        for(char c: s.toCharArray()) {
            
            char tmp = isFirst ? Character.toUpperCase(c) : c; 
            answer.append(tmp); 
            isFirst = c == ' '; 
      
        }
        
        return answer.toString();
    }
}