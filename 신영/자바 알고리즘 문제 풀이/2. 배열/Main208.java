// 2-7 점수 계산
// 2024-12-24 

import java.util.*;


public class Main208 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        ArrayList<Integer> score = new ArrayList<>(); 
        ArrayList<Integer> sortedScore = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt(); 
            score.add(num); 
            sortedScore.add(num); 
        }

        Collections.sort(sortedScore, Comparator.reverseOrder()); 

        for(int i = 0; i < n; i++) {
            System.out.print(sortedScore.indexOf(score.get(i)) + 1 + " ");
        }
        scan.close(); 
    }
}
