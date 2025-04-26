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
        double tmp = 0;
        List<Integer> ans = new ArrayList<>();
        for(double i = N; i > Math.sqrt(N); i--) {
            if(N / i ==  Math.floor(N / i)) {
                tmp = ((i + (N / i)) / 2);
                if(tmp == Math.floor(tmp)) ans.add((int) tmp);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
