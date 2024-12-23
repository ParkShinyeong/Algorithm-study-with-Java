// 11 문자열 압축  
// 2024-12-23

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.next(); 
        char tmp = str.charAt(0); 
        int count = 0; 
        String answer = ""; 

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); 
            if(tmp == c) {
                count++; 
            } else {
                if(count > 1) {
                    answer += tmp; 
                    answer += count;  
                } else {
                    answer += tmp; 
                }
                tmp = c; 
                count = 1; 
            }

            if(i == str.length() - 1) {
                answer += tmp; 
                if(count > 1) answer += count; 
            }
        }

        System.out.println(answer);
    }
}
