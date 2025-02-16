import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int test = Integer.parseInt(br.readLine()); 
        for(int tc = 0; tc < test; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1]; 
            String[] input = br.readLine().split(" "); 
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(input[i-1]); 
            }

            int[] visit = new int[N + 1]; 
            int cnt = 0; 
            for(int i = 1; i <= N; i++) {
                if(visit[i] == 1) continue; 
                int nxt = arr[i]; 
                while(visit[nxt] == 0) {
                    visit[nxt] = 1; 
                    nxt = arr[nxt]; 
                }
                cnt++; 
            }

            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
