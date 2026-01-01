
import java.io.*;
public class Main {
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        boolean[][] chess = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    chess[i][j] = true;
                } else {
                    chess[i][j] = false;
                }
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int cnt = T.solution(i, j, chess);
                min = Math.min(min, cnt);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        br.close();
        bw.close();
    }

    public int solution(int n, int m, boolean[][] chess) {
        int cnt = 0;
        boolean first = chess[n][m]; 
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (chess[i][j] != first) {
                    cnt++;
                }
                first = !first;
            }
            first = !first;
        }
        cnt = Math.min(cnt, 64 - cnt);
        return cnt;
    }
}