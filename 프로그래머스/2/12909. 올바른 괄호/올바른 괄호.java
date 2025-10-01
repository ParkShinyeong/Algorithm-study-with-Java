import java.util.*; 
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>(); 
        for(char c: s.toCharArray()) {
            if(c == '(') stack.offer(c);
            else {
                if(!stack.isEmpty() && stack.peekLast() == '(') {
                    stack.pop(); 
                } else {
                    stack.offer(c); 
                }
            }
        }
        if(stack.size() != 0) answer = false; 

        return answer;
    }
}