// 09 숫자만 추출
// 2024-12-23

import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 

        String str = scan.next(); 
        String num = ""; 
        for(char c: str.toCharArray()) {
            if(Character.isDigit(c)) {
                num += c; 
            }
        }

        int answer = Integer.parseInt(num); 
        System.out.println(answer);
    }
}
