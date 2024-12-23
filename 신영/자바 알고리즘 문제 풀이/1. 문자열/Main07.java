// 07 회문 문자열 
// 2024-12-23

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.next().toLowerCase(); 
        int lt = 0, rt = str.length() - 1; 
        String answer = "YES"; 

        while(lt < rt) {
            if(str.charAt(lt) == str.charAt(rt)) {
                lt++; 
                rt--; 
            } else {
                answer = "NO"; 
                break; 
            }
        }
        System.out.println(answer);
    }
    
}
