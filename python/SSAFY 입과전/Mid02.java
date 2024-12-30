import java.util.Arrays;
import java.util.Scanner;

public class Mid02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            // 입력하기 
		    int N = sc.nextInt(); 
            int[][] board = new int[N][N]; 
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt(); 
                }
            }

            // 회전시키기 
            int[][] degree90 = rotateBoard(N, board); 
            int[][] degree180 = rotateBoard(N, degree90); 
            int[][] degree270 = rotateBoard(N, degree180);
            
            // 출력하기 
            System.out.printf("#%d\n", test_case);
            for(int i = 0; i < N; i++) {
                String dg90 = Arrays.toString(degree90[i]).replaceAll("[\\[\\], ]", ""); 
                String dg180 = Arrays.toString(degree180[i]).replaceAll("[\\[\\], ]", ""); 
                String dg270 = Arrays.toString(degree270[i]).replaceAll("[\\[\\], ]", ""); 
                
                System.out.printf("%s %s %s", dg90, dg180, dg270);
                System.out.println();
            }

		}
    }

    public static int[][] rotateBoard(int n, int[][] board) {
        int[][] newBoard = new int[n][n]; 
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newBoard[i][j] = board[n - 1 - j][i]; 
            }
        }
        return newBoard; 
    }
    
}
