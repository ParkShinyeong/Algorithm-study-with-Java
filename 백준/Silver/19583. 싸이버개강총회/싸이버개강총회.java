import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int start = getTime(st.nextToken()); 
        int end = getTime(st.nextToken()); 
        int streamingEnd = getTime(st.nextToken()); 

        HashSet<String> enterStudents = new HashSet<>(); 
        HashSet<String> outStudents = new HashSet<>(); 

        String line; 

        while((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line); 
            int time = getTime(st.nextToken()); 
            String student = st.nextToken(); 

            if(time <= start) {
                enterStudents.add(student); 
            } else if (end <= time && time <= streamingEnd && enterStudents.contains(student)) {
                outStudents.add(student); 
            }
        }
        bw.write(outStudents.size() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int getTime(String timeStr) {
        String[] times = timeStr.split(":"); 
        return Integer.parseInt(times[0]) * 100 + Integer.parseInt(times[1]);
    }
}
