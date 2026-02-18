import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        int[] nums = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
        }

        int[] sortNum = new int[N]; 
        System.arraycopy(nums, 0, sortNum, 0, N); 
        Arrays.sort(sortNum); 

        ArrayList<Integer> removeSameNum = new ArrayList<>(); 
        
        int prev = sortNum[0]; 
        removeSameNum.add(prev); 
        for(int i = 1; i < N; i++) {
            if(prev != sortNum[i]) removeSameNum.add(sortNum[i]); 
            prev = sortNum[i]; 
        };

        for(int n: nums) {
            bw.write(Collections.binarySearch(removeSameNum, n) + " "); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}