import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> ans = solution(N);
        for(int num: ans) {
            bw.write(num + "\n");
        }
        if(ans.size() == 0) bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> solution(int N) throws IOException {
        List<Integer> ans = new ArrayList<>();
        int x = 1;
        int y = 2;
        while(y > x) {
            double calc = Math.pow(y, 2) - Math.pow(x, 2);
            if(calc == N) {
                ans.add(y);
                x++;
            }
            else if(calc < N) y++;
            else x++;
        }

        return ans;
    }
}
