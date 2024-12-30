import java.util.Arrays;
import java.util.Scanner;

public class Easy03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int[] nums = new int[n]; 

        for(int i = 0 ; i < n; i++) {
            nums[i] = scan.nextInt(); 
        }

        Arrays.sort(nums); 
        System.out.println(nums[n / 2]);
    }
}
