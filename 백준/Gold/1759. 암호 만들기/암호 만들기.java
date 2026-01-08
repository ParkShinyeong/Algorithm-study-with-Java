import java.io.*;
import java.util.*; 

public class Main {
    static int L, C; 
    static char[] arr; 
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        L = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine()); 
        arr = new char[C]; 

        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0); 
        }

        Arrays.sort(arr); 
        func(0, 0, ""); 
        bw.write(sb.toString()); 
        bw.flush();
        bw.close();
        br.close();
    }

    static void func(int cnt, int idx, String code) {
        if(cnt == L) {
            if(checkCode(code)) sb.append(code).append("\n"); 
            return; 
        }

        for(int i = idx; i < C; i++) {
            func(cnt + 1, i + 1, code + arr[i]); 
        }
    }

    static boolean checkCode(String code) {
        int cnt = 0; 

        for(char c: code.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++; 
            }
        }

        if(cnt >= 1 && L - cnt >= 2) return true; 
        return false; 
    }


}