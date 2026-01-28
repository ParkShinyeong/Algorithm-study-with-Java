import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int[] arr, operators; 
    static int min, max; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        N = Integer.parseInt(br.readLine()); 
        arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        
        st = new StringTokenizer(br.readLine()); 
        operators = new int[4]; 
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken()); 
        }

        min = Integer.MAX_VALUE; 
        max = Integer.MIN_VALUE; 

        setOperators(0, new int[N - 1]); 

        bw.write(max +"\n" + min); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static void setOperators(int cnt, int[] useOper) {
        if(cnt == N - 1) {
            int result = calculate(useOper); 
            min = Math.min(min, result); 
            max = Math.max(max, result);
            return; 
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] == 0) continue; 
            operators[i]--; 
            useOper[cnt] = i;  
            setOperators(cnt + 1, useOper); 
            operators[i]++; 
        }
    }

    static int calculate(int[] opers) {
        int total = arr[0]; 
        for(int i = 1; i < N; i++) {
            switch(opers[i - 1]) {
                case 0: // +
                    total += arr[i]; 
                    break; 
                case 1: // -
                    total -= arr[i]; 
                    break; 
                case 2: // x
                    total *= arr[i]; 
                    break; 
                case 3: // /
                    total /= arr[i]; 
                    break; 
            }
        }
        return total; 
    }
}