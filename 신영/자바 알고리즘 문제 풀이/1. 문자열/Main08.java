// 08 회문 문자열 
// 2024-12-23

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        String str = input.nextLine().toUpperCase();
        String alpabetStr = ""; 
        String answer = "YES"; 

        // 알파벳이 아닌 문자를 제거한다. 
        for(char c : str.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                alpabetStr += c; 
            }
        }
        // replaceAll과 정규표현식을 사용해서 제거할 수도 있다. 
        // alpabetStr = str.replaceAll("[^A-Z]", ""); 

        String reverseStr = String.valueOf(new StringBuffer(alpabetStr).reverse()); 
        if(!reverseStr.equals(alpabetStr)) answer = "NO"; 

        System.out.println(answer);


    }
}
