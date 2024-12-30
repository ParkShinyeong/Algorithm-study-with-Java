import java.util.Scanner;

public class Easy02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int num = scan.nextInt(); 
        int answer = 0; 

        while(num > 0) {
            int one = num % 10; 
            answer += one; 
            num = num / 10;
        }

        System.out.println(answer);
    }
}
