// 2-12 멘토링   
// 2024-12-26
import java.util.*;

public class Main212 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int stdNum = scan.nextInt(); 
        int testNum = scan.nextInt(); 

        int[][] board = new int[testNum][stdNum]; 

        for(int i= 0; i < testNum; i++) {
            for(int j = 0; j < stdNum; j++) {
                board[i][j] = scan.nextInt(); 
            }
        }

        
    }
}
