import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
        int n = Integer.parseInt(br.readLine()); 
        int[][] homes = new int[n + 1][3]; 
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for(int j = 0; j < 3; j++) {
                homes[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
		
        int answer = solution(n, homes); 
        bw.write(answer + ""); 
		bw.flush();
		bw.close();
    }

    public static int solution(int n, int[][] homes) {
        for(int i = 2; i <= n; i++) {
            homes[i][0] += Math.min(homes[i-1][1], homes[i-1][2]); 
            homes[i][1] += Math.min(homes[i-1][0], homes[i-1][2]); 
            homes[i][2] += Math.min(homes[i-1][0], homes[i-1][1]); 
        }

        return Math.min(homes[n][0], Math.min(homes[n][1], homes[n][2])); 
    }
}