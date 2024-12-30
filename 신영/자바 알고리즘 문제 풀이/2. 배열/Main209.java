// 2-9 격자판 최대합 
// 2024-12-26
import java.util.*;
public class Main209 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int[][] board = new int[n][n]; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt(); 
            }
        }

        int max = 0; 

        for(int i = 0; i < n; i++) {
            int rowSum = 0; 
            int columnSum = 0; 
            for(int j = 0; j < n; j++) {
                rowSum += board[i][j];
                columnSum += board[j][i]; 
            }

            max = Math.max(Math.max(rowSum, columnSum), max); 
        }

        int diagonal = 0;
        int reverseDiagonal = 0;  
        for(int i = 0; i < n; i++) {
            diagonal += board[i][i]; 
            reverseDiagonal += board[i][n - i - 1]; 
        }

        System.out.println(Math.max(max, Math.max(diagonal, reverseDiagonal)));
    }
}
