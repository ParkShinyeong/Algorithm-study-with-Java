// 2-1 큰 수 출력하기 
// 2024-12-24

import java.util.Scanner;

public class Main201 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int num = scan.nextInt(); 
        scan.nextLine(); 
        String numbers = "0 "+ scan.nextLine(); 
        String[] nums = numbers.split(" "); 
        String answer = ""; 

        for(int i = 1; i <= num; i++) {
            if(Integer.parseInt(nums[i - 1]) < Integer.parseInt(nums[i])) answer += nums[i] + " "; 
        }

        System.out.println(answer);
        

    }
}
