import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 

        bw.write(solution() + "");
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        int cnt = 0; 
        int[] primeNums = getPrimeNumbers(); 

        int st = 0, ed = 0; 
        int sum = 0; 
        while(true) {
            if(sum == N) {
                cnt++; 
                sum -= primeNums[st++]; 
            } else if (sum > N) {
                sum -= primeNums[st++]; 
            } else if (ed == primeNums.length) {
                break; 
            } else {
                sum += primeNums[ed++]; 
            }
        }
        return cnt; 
    }

    private static int[] getPrimeNumbers() {
        boolean[] nums = new boolean[N + 1]; 
        ArrayList<Integer> primeNums = new ArrayList<>(); 
        for(int i = 2; i <= N; i++) {
            if(!nums[i]) {
                primeNums.add(i); 
                for(int j = i + i; j <= N; j += i) nums[j] = true; 
            }
        }
        return primeNums.stream().mapToInt(Integer::valueOf).toArray(); 
    }
}