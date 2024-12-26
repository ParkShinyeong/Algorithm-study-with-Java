// 2-7 점수 계산
// 2024-12-24 

import java.util.Scanner;

public class Main207 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt();
        int result = 0; 
        int point = 1;  
        for(int i = 0; i < n; i++) {
            int score = scan.nextInt(); 
            if(score == 1) {
                result += point++; 
            } else {
                point = 1; 
            }
        }

        System.out.println(result);
    }
    
}
