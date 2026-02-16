import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); 
        int tmp = N; 
        int n = 2; 
        while(tmp != 1) { 
            if(tmp % n == 0) {
                bw.write(n + "\n"); 
                tmp /= n; 
            } else {
                n++; 
            }
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}