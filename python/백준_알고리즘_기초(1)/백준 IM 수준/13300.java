import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

        int[][] studentCnt = new int[2][6]; 
        
        for(int i = 0; i < n; i++) {
            int sex = sc.nextInt(); 
            int year = sc.nextInt(); 

            studentCnt[sex][year - 1]++; 
        }

        int answer = 0; 
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 6; j++) {
                int cnt = studentCnt[i][j]; 
                if (cnt % k == 0) answer += cnt / k; 
                else {
                    answer += (cnt + k - 1) / k; 
                }
            }
        }

        System.out.println(answer);

    }    
}
