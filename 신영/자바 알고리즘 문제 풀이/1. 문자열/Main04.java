// 04 단어 뒤집기 
// 2024-12-23

import java.util.Scanner;

public class Main04 {
    // public static String reverseStr(StringBuffer str) {
    //     String answer = ""; 
    //     for(char c: str.toCharArray()) {
    //         answer = c + answer; 
    //     }
    //     return answer; 
    // }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int num = scan.nextInt(); 
        StringBuffer[] strArr = new StringBuffer[num]; 
        for(int i = 0; i < num; i++) {
            strArr[i] = new StringBuffer(scan.next()); 
        }
        
        for(StringBuffer str: strArr) {
            System.out.println(str.reverse());
        }

    }
    
}
