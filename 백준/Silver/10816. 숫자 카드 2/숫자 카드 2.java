import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" "); 
        HashMap<String, Integer> cards = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = inputs[i];
            if (cards.containsKey(key)) {
                cards.put(key, cards.get(key) + 1);
            } else {
                cards.put(key, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] checkNum = br.readLine().split(" "); 
        
        for (int i = 0; i < m; i++) {
            if (cards.containsKey(checkNum[i])) {
                bw.write(String.valueOf(cards.get(checkNum[i])));
            } else {
                bw.write("0");
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}