import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1]; 
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        bw.write(solution(n, arr)); 
        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(int n, int[] arr) {
        int[] ans = new int[n + 1]; 
        Stack<int[]> st = new Stack<>(); 

        for(int i = 1; i <= n; i++) {
            int tower = 0; 
            while(!st.isEmpty()) {
                if(st.peek()[0] > arr[i]) {
                    tower = st.peek()[1]; 
                    break; 
                } else {
                    st.pop(); 
                }
            }
            ans[i] = tower;
            st.push(new int[] { arr[i], i }); 
        }
        StringBuilder sb = new StringBuilder(); 
        for(int i = 1; i <= n; i++) {
            sb.append(ans[i] + " "); 
        }
        return sb.toString(); 
    }
}
