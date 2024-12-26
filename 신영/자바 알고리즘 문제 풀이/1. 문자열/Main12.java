// 12 암호 
// 2024-12-24

import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int cnt = scan.nextInt(); 
        // nextInt()는 숫자를 읽고 줄바꿈 문자를 남긴다 
        // 줄바꿈 문자가 이후 nextLine 호출에 영향을 줌
        // nextLine을 한번 호출하여 남아있는 줄바꿈 문자를 처리한다. 
        // scan.nextLine();  
        // String code = scan.nextLine(); 
        String code = scan.next(); 
        scan.close(); 
        String answer = ""; 

        // char[] codeArr = new char[cnt]; 

        for (int i = 0; i < cnt; i++) {
            // String binaryString = "";  
            // for(int j = 0; j < 7; j++) {
            //     if(code.charAt(j) == '#') {
            //         binaryString += 1; 
            //     } else if(code.charAt(j) == '*') {
            //         binaryString += 0; 
            //     }
            // }
            String tmp = code.substring(0, 7).replace("#", "1").replace("*", "0"); 

            code = code.substring(7); 
            int binaryNum = Integer.parseInt(tmp, 2); 
            answer += (char)binaryNum; 
            
        }

        System.out.println(answer);
    }
    
}
