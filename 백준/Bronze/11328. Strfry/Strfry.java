import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            String str1 = st.nextToken(); 
            String str2 = st.nextToken(); 
            if(isPossible(str1, str2)) bw.write("Possible\n"); 
            else bw.write("Impossible\n"); 
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean isPossible(String str1, String str2) {
        int[] chars = new int[26]; 
        for(char c : str1.toCharArray()) {
            chars[c - 'a']++; 
        }
        for(char c : str2.toCharArray()) {
            chars[c - 'a']--; 
        }
        for(int i = 0; i < 26; i++) {
            if(chars[i] != 0) return false; 
        }
        return true; 
    }
}
