import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 
        Integer[] numbers = new Integer[N]; 

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(numbers, (a, b) -> {
            if(a < 0 && b < 0) {
                return a - b; 
            } 
            return b - a; 
        });
        
        int idx1 = 0, idx2 = 1;
        int answer = 0; 
        int zeroCnt = 0; 
        
        while(idx1 < N) {
            int num1 = numbers[idx1]; 
            if(idx2 >= N) {
                if(!(num1 < 0 && zeroCnt > 0)) answer += num1;
                break; 
            }
            int num2 = numbers[idx2]; 
            
            if(num1 * num2 == 0) {
                if(num1 > 0) answer += num1; 
                zeroCnt++; 
            }else if(num1 * num2 >= 0 && num1 * num2 > num1 + num2) {
                answer += num1 * num2; 
                idx1++; 
                idx2++; 
            } else {
                answer += num1; 
            }
            idx1++; 
            idx2++;
        }
        bw.write(answer + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}