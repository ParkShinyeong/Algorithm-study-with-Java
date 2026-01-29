import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int N = Integer.parseInt(br.readLine()); 

        int[] arr = new int[N + 1]; 

        for(int n = 2; n <= N; n++) {
            int min = Integer.MAX_VALUE; 
            if(n % 3 == 0) min = Math.min(min, arr[n / 3] + 1); 
            if(n % 2 == 0) min = Math.min(min, arr[n / 2] + 1); 
            min = Math.min(min, arr[n - 1] + 1); 
            arr[n] = min; 
        }

        bw.write(String.valueOf(arr[N])); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}