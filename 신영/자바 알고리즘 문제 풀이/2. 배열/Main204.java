// 2-4 피보나치 수열 
// 2024-12-24

import java.util.ArrayList;
import java.util.Scanner;

public class Main204 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int num = scan.nextInt(); 
        ArrayList<Integer> piboArr = new ArrayList<>(); 
        String answer = ""; 

        for(int i = 0; i < num; i++) {
            if(i < 2) {
                piboArr.add(1); 
                answer += "1 "; 
            } else {
                int tmp = piboArr.get(i - 2) + piboArr.get(i - 1); 
                piboArr.add(tmp); 
                answer += tmp + " "; 
            }
        }

        System.out.println(answer);
    }
    
}
