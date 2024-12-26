// 2-6 뒤집은 소수 
// 2024-12-24 

import java.util.Scanner;

public class Main206 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int cnt = scan.nextInt(); 
        for(int i = 0; i < cnt; i++) {
            // StringBuffer strNum = new StringBuffer(scan.next()); 
            // int num = Integer.parseInt(strNum.reverse() + ""); 
            // if(Main206.checkPrimeNumber(num)) {
            //     System.out.print(num + " ");
            // }

            int n = scan.nextInt(); 
            int reverseNum = reverseNumber(n); 

            if(checkPrimeNumber(reverseNum)) System.out.print(reverseNum + " ");
        }
    }

    public static int reverseNumber(int n) {
        int result = 0; 
        while(n > 0) {
            int singleDigit = n % 10; 
            n = n / 10; 
            result = ((result * 10) + singleDigit); 
        }
        return result; 
    }

    public static boolean checkPrimeNumber(int n) {
        // int[] check = new int[n + 1]; 
        // for(int i = 2; i <= n; i++ ) {
        //     for(int j = i; j <= n; j+= i) {
        //         check[j] += 1; 
        //     }  
        // }
        // return check[n] == 1; 

        if(n == 1) return false; 
        else {
            for(int i  = 2; i < n; i++) {
                if(n % i == 0) return false; 
            }
        }
        return true; 
    }
    
}
