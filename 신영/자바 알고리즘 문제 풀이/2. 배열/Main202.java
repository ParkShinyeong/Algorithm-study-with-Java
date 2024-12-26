// 2-2 보이는 학생 
// 2024-12-24

import java.util.Scanner;

public class Main202 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt(); 
        int[] student = new int[cnt]; 
        for(int i = 0; i < cnt; i++) {
            student[i] = scan.nextInt(); 
        }

        int max = 0; 
        int answer = 0; 
        for(int i = 0; i < cnt; i++) {
            int tmpStd = student[i]; 
            if(max < tmpStd) {
                answer++; 
                max = tmpStd; 
            } 
        }

        System.out.println(answer);
    }
    
}
