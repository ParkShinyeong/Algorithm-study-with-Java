
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 

            int[][] board = new int[n][n];
            for(int i = 0;i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt(); 
                }
            }

            int max = 0; 

            // + 모양으로 뿌리기
            for(int i = 0;i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int total = board[i][j]; 
                    for(int k = 1; k < m; k++) {
                        if(j + k < n) total += board[i][j + k]; 
                        if(j - k >= 0) total += board[i][j - k]; 
                        if(i + k < n) total += board[i + k][j]; 
                        if(i - k >= 0) total += board[i - k][j]; 
                    }
                    max = Math.max(max, total); 
                }
            }

            // x 모양으로 뿌리기 
            for(int i = 0;i < n; i++) {
                for(int j = 0; j < n; j++) {
                   int total = board[i][j]; 
                   for(int k = 1; k < m; k++) {
                        if(i - k >= 0 && j - k >= 0) total += board[i - k][j - k]; 
                        if(i - k >= 0 && j + k < n) total += board[i - k][j + k]; 
                        if(i + k < n && j - k >= 0) total += board[i + k][j - k]; 
                        if(i + k < n && j + k < n) total += board[i + k][j + k]; 
                   }
                   max = Math.max(max, total); 
                }
            }

            System.out.printf("#%d ", test_case);
            System.out.println(max);
		}
	}
}