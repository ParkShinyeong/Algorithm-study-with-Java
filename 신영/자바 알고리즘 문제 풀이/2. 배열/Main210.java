// 2-10 봉우리  
// 2024-12-26
import java.util.*;

public class Main210 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int[][] board = new int[n+2][n+2]; 
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                board[i][j] = scan.nextInt(); 
            }
        }

        int answer = 0; 

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int top = board[i - 1][j]; 
                int bottom = board[i + 1][j]; 
                int left = board[i][j - 1]; 
                int right = board[i][j + 1]; 
                int tmp = board[i][j]; 

                if(tmp > top && tmp > bottom && tmp > left && tmp > right) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
