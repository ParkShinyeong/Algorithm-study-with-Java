import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        int F = Integer.parseInt(br.readLine()); 
        int nn = (N / 100) * 100; 

        while(nn % F != 0) {
            nn++; 
        }
        String answer = (nn % 100) + ""; 
        if(answer.length() == 1) answer = "0" + answer; 
        bw.write(answer); 
        bw.flush();
        bw.close();
        br.close();
    }
}
