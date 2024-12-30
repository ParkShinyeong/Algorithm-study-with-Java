import java.util.Arrays;
import java.util.Scanner;

public class Mid01 {
    public static int maxSum(int[] first, int[] second) {
        int max = Integer.MIN_VALUE; 
        int pos = 0; 

        while (pos <= first.length - second.length) {
            int sum = 0; 
            for(int i = 0; i < second.length; i++) {
                sum += first[i + pos] * second[i]; 
            }
            max = Math.max(sum, max);
            pos++;  
        }

        return max; 
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); 
            int M = sc.nextInt(); 
            // sc.nextLine(); 
            // int[] A = Arrays.stream(sc.nextLine().split(" "))
            //     .mapToInt(Integer::parseInt)
            //     .toArray(); 
            // int[] B = Arrays.stream(sc.nextLine().split(" "))
            //     .mapToInt(Integer::parseInt)
            //     .toArray();
            int[] A = new int[N]; 
            int[] B = new int[M]; 

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt(); 
            } 
            
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt(); 
            } 
            
            int answer = 0; 
            if (N > M) {
                answer = maxSum(A, B); 
            } else {
                answer = maxSum(B, A); 
            }

            System.out.printf("#%d %d\n", test_case, answer);
		} 

     }
}
