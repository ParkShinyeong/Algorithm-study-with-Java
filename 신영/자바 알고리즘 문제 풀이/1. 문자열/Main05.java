

//05 특정 문자 뒤집기 
// 2024-12-23

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        String str = new String(scan.next()); 
        // System.out.println(Main05.myAnswer(str));
        System.out.println(Main05.lectureAnswer(str));
    }

    public static String myAnswer(String str) {
        // 알파벳만 담을 버퍼 생성. 
        StringBuffer alphabet = new StringBuffer(); 
        // 알파벳 위치를 담을 큐 생성 
        Queue alphabetIdx = new LinkedList<>(); 

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); 
            // 문자가 알파벳이면 알파벳과 위치를 저장한다. 
            if(!Character.isAlphabetic(c)){
                alphabet.append(c); 
                alphabetIdx.add(i); 
            }
        }

        // 알파벳 위치를 뒤집는다. 
        String reverseStr = new String(alphabet.reverse()); 
        String answer = ""; 
        for(int i = 0; i < str.length(); i++) {
            // 알파벳 위치 큐에 값이 존재하고, i와 그 값이 같으면 알파벳을 교체한다. 
            if(!alphabetIdx.isEmpty() && (int)alphabetIdx.peek() == i) {
                alphabetIdx.poll(); 
                answer += reverseStr.charAt(0); 
                reverseStr = reverseStr.substring(1); 
            } else {
                answer += str.charAt(i); 
            }
        }

        return answer; 
    }

    public static String lectureAnswer(String str) {
        String answer = ""; 
        char[] charArr = str.toCharArray(); 
        int lt = 0, rt = str.length() - 1; 
        while(lt < rt) {
           
            if(!Character.isAlphabetic(charArr[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(charArr[rt])) {
                rt--; 
            } else {
                char tmp = charArr[lt]; 
                charArr[lt] = charArr[rt]; 
                charArr[rt] = tmp; 
                lt++; 
                rt--; 
            }
        }

        answer = String.valueOf(charArr); 
        return answer; 
    }
   
}
