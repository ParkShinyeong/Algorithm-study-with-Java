import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt(); 
        int W = sc.nextInt(); 

        int[] trees = new int[T + 1];
        
        for(int i = 1; i <= T; i++) {
            trees[i] = sc.nextInt(); 
        }
        int[][][] dp = new int[3][T + 1][W + 1];
        for(int[][] row1: dp) {
            for(int[] row2: row1) Arrays.fill(row2, -1); 
        }
        dp[1][0][0] = 0; // 0 초일 때 1번 나무, 이동 0번 
        for(int t = 1; t < T + 1; t++) {
            for(int m = 0; m <= W; m++) {
                int tmp = trees[t] == 1 ? 1 : 0; 
                if(dp[1][t-1][m] != -1) { // 이전에 1번에 있었고, 가만이 있었던 경우 
                    dp[1][t][m] = Math.max(dp[1][t][m], dp[1][t-1][m] + tmp);
                } 
                if(m > 0 && dp[2][t-1][m-1] != -1) { // 이전에 2번에 있었고, 지금 1번으로 옮기는 경우 
                   dp[1][t][m] = Math.max(dp[1][t][m], dp[2][t-1][m-1] + tmp);
                }
               tmp = trees[t] == 2 ? 1 : 0; 
               if(dp[2][t-1][m] != -1) {
                dp[2][t][m]  = Math.max(dp[2][t][m], dp[2][t - 1][m] + tmp); 
               } 
               if(m > 0 && dp[1][t-1][m - 1] != -1) {
                dp[2][t][m] = Math.max(dp[2][t][m], dp[1][t-1][m - 1] + tmp); 
               }
            }
        }
        int ans = 0; 
        for(int i = 0; i <= W; i++) {
            ans = Math.max(ans, Math.max(dp[1][T][i], dp[2][T][i])); 
        }
        System.out.println(ans);
        sc.close();
    }
}