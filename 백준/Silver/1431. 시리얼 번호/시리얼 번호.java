import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 

        ArrayList<String> serialList = new ArrayList<>(); 

        for(int i = 0; i < N; i++) {
            serialList.add(br.readLine()); 
        }

        serialList.sort((a, b) -> {

            if(a.length() != b.length()) {
                return a.length() - b.length(); 
            }
            int aSum = getSum(a); 
            int bSum = getSum(b); 
            if(aSum != bSum) return aSum - bSum; 

            return a.compareTo(b); 
        }); 

        for(String str: serialList) {
            bw.write(str + "\n"); 
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static int getSum(String str) {
        int sum = 0; 
        for(char c : str.toCharArray()) {
            int tmp = Integer.valueOf(c - '0'); 
            if (tmp >= 0 && tmp < 10) sum += tmp; 
        }

        return sum; 
    }
}