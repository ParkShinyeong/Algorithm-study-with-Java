import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in); 
        int n, m; 
        while((n = sc.nextInt()) != 0 && (m = sc.nextInt()) != 0) {
            if(n > m) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
