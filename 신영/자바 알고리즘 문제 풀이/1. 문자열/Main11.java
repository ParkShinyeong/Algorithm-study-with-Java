// 11 문자열 압축  
// 2024-12-23

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.next() + " "; 
        int count = 1; 
        String answer = ""; 

        for(int i = 0; i < str.length() - 1; i++) {
            char prev = str.charAt(i); 
            char tmp = str.charAt(i + 1); 
            if(prev == tmp) {
                // 중복될 때 
                count++; 
            } else {
                // 중복되지 않을 때 
                answer += prev; 
                if(count > 1) { // count가 1 이상이면 개수를 추가한다. 
                    answer += count;  
                }
                count = 1; 
            }
        }

        System.out.println(answer);
    }
}
