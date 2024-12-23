// 10 가장 짧은 문자거리 
// 2024-12-23

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); 
       String str = scanner.next(); 
       char chr = scanner.next().charAt(0); 

       int prev=0, tmp=str.indexOf(chr); 
       int[] position = new int[str.length()]; 

       for(int i = 0; i < str.length(); i++) {
        if(i > tmp && str.charAt(i) == str.charAt(tmp)) {
            prev = tmp; 
            tmp = i; 
            for(int j = prev + 1; j < tmp; j++) {
                position[j] = Math.min(position[j], tmp - j); 
                // if (position[j] > tmp - j) {
                //     position[j] = tmp - j; 
                // }
            }
        }
        position[i] = Math.abs(tmp - i); 
       }
       String answer = Arrays.toString(position).replace(",", ""); 
       System.out.println(answer.substring(1, answer.length() - 1));
      

    }
    
}
