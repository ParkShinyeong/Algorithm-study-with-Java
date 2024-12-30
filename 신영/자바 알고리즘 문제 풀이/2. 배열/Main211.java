// 2-11 임시 반장 정하기  
// 2024-12-26
import java.util.*;


public class Main211 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int[][] board = new int[n][5]; 

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt(); 
            }
        }

        int[][] checkClassmate = new int[n][n]; 

        for(int std = 0; std < n; std++) {
            for(int grade = 0; grade < 5; grade++) {
                int classNum = board[std][grade]; 
                System.out.println("classNum: " + classNum);
                for(int otherStd = 0; otherStd < n; otherStd++) {
                    System.out.println("otherStd class: " + board[otherStd][grade]);
                    if(board[otherStd][grade] == classNum) {
                        checkClassmate[std][otherStd] += 1; 
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(checkClassmate));

        int answer = 0; 
        int max = 0; 
        for(int i = 0; i < n; i++) {
            int popular = 0; 
            for(int j = 0; j < n; j++) {
                if(checkClassmate[i][j] > 1) popular++; 
            }
            if(max < popular) {
                max = popular; 
                answer = i + 1; 
            }
        }

        System.out.println(answer);
        
    }
}
