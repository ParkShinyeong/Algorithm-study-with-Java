import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n == 0) break; 
            int sum = 0;  
            for(int i = 1; i <= n; i++) {
                sum += i; 
            }
            System.out.println(sum);
        }
    }
}