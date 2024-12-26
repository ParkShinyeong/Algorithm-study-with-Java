// 2-5 소수  
// 2024-12-24

import java.util.Scanner;

public class Main205 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(); 
        scan.close(); 

        int[] count = new int[num + 1]; 
        int answer = 0; 

        for(int i = 2; i <= num; i++) {
            count[i] += 1; 
            for(int j = 2; j * i <= num; j++) {
                count[j * i] += 1; 
            }
        }

        for(int i = 2; i <= num; i++) {
            if(count[i] == 1) answer++; 
        }

        System.out.println(answer);
    }
    
}
