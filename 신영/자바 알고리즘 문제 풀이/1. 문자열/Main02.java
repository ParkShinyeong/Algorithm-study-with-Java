
//02 대소문자 변환 문제 
// 2024-12-23

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.next(); 
        String answer = ""; 
        // String upperStr = str.toUpperCase(); 

        // for(int i = 0; i < str.length(); i++) {
        //     if (str.charAt(i) == upperStr.charAt(i)) {
        //         answer += Character.toLowerCase(str.charAt(i)); 
        //     } else {
        //         answer += upperStr.charAt(i); 
        //     }
        // }

        for(char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c); 
            } else {
                answer += Character.toLowerCase(c); 
            }
        }
        System.out.println(answer);
    }
}