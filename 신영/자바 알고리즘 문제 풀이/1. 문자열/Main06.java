// 06 중복 문자 제거 
// 2024-12-23

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.next(); 
        String answer = ""; 
        
        for(char c: str.toCharArray()) {
            if(answer.indexOf(c) == -1) {
                answer += c; 
            }
        }

        System.out.println(answer);
    } 
    
}
