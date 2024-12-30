import java.util.Scanner;

public class Easy01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int A = scan.nextInt(); 
        int B = scan.nextInt(); 

        char answer = 'A'; 
        if(B > A && B < 3 || B == 1 && A == 3) {
            answer = 'B'; 
        } 

        System.out.println(answer);
    }
}