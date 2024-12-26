// 2-3 가위바위보
// 2024-12-24

import java.util.Scanner;

public class Main203 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int cnt = scan.nextInt(); 
        int[] aTurn = new int[cnt]; 
        int[] bTurn = new int[cnt]; 
        
        for(int i = 0; i < cnt; i++) {
            aTurn[i] = scan.nextInt(); 
        }
        
        for(int i = 0; i < cnt; i++) {
            bTurn[i] = scan.nextInt(); 
        }

        for(int i = 0; i < cnt; i++) {
            int A = aTurn[i]; 
            int B = bTurn[i]; 

            if(A - B == 1 || B - A == 2) {
                System.out.println("A");
            } else if (B - A == 1 || A - B == 2) {
                System.out.println("B");
            } else if (A == B) {
                System.out.println("D");
            }
        }
    }
}
