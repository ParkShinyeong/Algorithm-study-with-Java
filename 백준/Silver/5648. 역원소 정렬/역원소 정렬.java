import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = sc.nextInt(); 

        long[] nums = new long[N]; 

        for(int i = 0; i < N; i++) {
            while(!sc.hasNextLong()) sc.next(); //숫자가 아니면 건너뜀 
            long input = sc.nextLong(); 
            nums[i] = reverseNumber(input); 
        }

        Arrays.sort(nums);

        for(long num: nums) {
            bw.write(num + "\n"); 
        }
       
        bw.flush(); 
        bw.close(); 
    }

    static long reverseNumber(long n) {
        String newStr = "0";  
        while(n > 0) {
            newStr += n % 10;
            n /= 10; 
        }
        return Long.parseLong(newStr); 
    }
}