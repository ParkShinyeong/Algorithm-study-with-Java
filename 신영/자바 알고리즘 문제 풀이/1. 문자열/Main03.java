// 03. 문장 속 단어 
// 2024-12-23

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = scan.nextLine(); 
        int max = 0; 
        String answer = ""; 

        String[] strArr = str.split(" "); 
        for(String word: strArr) {
            if(max < word.length()) {
                max = word.length(); 
                answer = word; 
            }
        }

        System.out.println(answer);
    }
}
