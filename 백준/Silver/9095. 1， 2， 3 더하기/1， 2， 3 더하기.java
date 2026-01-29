
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int T = Integer.parseInt(br.readLine()); 

        int[] arr = solution(); 

        for(int t = 0; t < T; t++) {
            int input = Integer.parseInt(br.readLine()); 
            bw.write(arr[input] + "\n"); 
        }

        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    static int[] solution() {
        int[] arr = new int[12]; 
        arr[1] = 1; 
        arr[2] = 2; 
        arr[3] = 4; 

        for(int i = 4; i < 12; i++) {
            if(i >= 1) arr[i] += arr[i - 1]; 
            if(i >= 2) arr[i] += arr[i - 2]; 
            if(i >= 3) arr[i] += arr[i - 3]; 
        }

        return arr; 
    }
}