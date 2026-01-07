import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static int[] arr; 
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine()); 
        arr = new int[N]; 

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(arr);

        recur(0, 0, new int[M]); 

        bw.write(sb.toString()); 

        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int cnt, int prevIdx, int[] seq) {
        if(cnt == M) {
            for(int num: seq) {
                sb.append(num).append(" "); 
            }
            sb.append("\n"); 
            return; 
        }
        int last = -1; // 같은 깊이에서 중복을 체크한다 
        for(int i = prevIdx; i < arr.length; i++) {
            if(last == arr[i]) continue; 
            last = arr[i]; 
            seq[cnt] = arr[i]; 
            recur(cnt + 1, i, seq); 
        }
    }
}
