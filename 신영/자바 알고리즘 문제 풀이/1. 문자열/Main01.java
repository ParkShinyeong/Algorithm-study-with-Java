import java.util.Scanner;

// 01 문자 찾기 
// 2024-12-23

public class Main01 {
    public int solution(String str, char t) {
        int answer = 0; 
        str = str.toUpperCase(); 
        t = Character.toUpperCase(t); 
        for(char c: str.toCharArray()) {
            if(c == t) {
                answer++; 
            }
        }

        // for(int i = 0; i < str.length(); i++) {
        //     if (str.charAt(i) == t) {
        //         answer++; 
        //     }
        // }
        return answer; 
    }
    public static void main(String[] args) {
        Main01 T = new Main01(); 
        Scanner scanner = new Scanner(System.in); 
        String str = scanner.nextLine(); 
        char chr = scanner.nextLine().charAt(0); 
        System.out.println(T.solution(str, chr));
        scanner.close(); 
        
    }
}