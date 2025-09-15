import java.util.*; 

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book); 
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            String num1 = phone_book[i]; 
            String num2 = phone_book[i + 1]; 
            boolean flag = true; 
            for(int j = 0; j < num1.length(); j++) {
                if(num1.charAt(j) != num2.charAt(j)) {
                    flag = false; 
                    break; 
                }
            }
            
            if(flag) {
                answer = false;
                break; 
            }
        }
        return answer;
    }
}