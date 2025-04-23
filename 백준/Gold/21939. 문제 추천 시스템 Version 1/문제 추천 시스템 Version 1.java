import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<int[]> problems;
    static HashMap<Integer, Integer> isUsing = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        problems = new TreeSet<>((a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        }); // 레벨 순으로 오름차순 정렬
        int N = Integer.parseInt(br.readLine()); // 문제의 개수
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problems.add(new int[] {problem, level});
            isUsing.put(problem, level);
        }
        int M = Integer.parseInt(br.readLine()); // 명령문의 개수

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "add" :
                    int problem = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    add(problem, level);
                    break;
                case "solved":
                    problem = Integer.parseInt(st.nextToken());
                    solved(problem);
                    break;
                case "recommend" :
                    int comm = Integer.parseInt(st.nextToken());
                    recommend(comm);
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void add(int problem, int level) {
        problems.add(new int[] {problem, level});
        isUsing.put(problem, level);
    }

    static void solved(int problem) {
        isUsing.put(problem, -1);
    }

    static void recommend(int comm) throws IOException {
        if(comm == 1) {
            int[] last = problems.last();
            while(isUsing.get(last[0]) != last[1]) {
                problems.pollLast();
                last = problems.last();
            }
            bw.write(problems.last()[0] + "\n");
        } else {
            int[] first = problems.first();
            while(isUsing.get(first[0]) != first[1]) {
                problems.pollFirst();
                first = problems.first();
            }
            bw.write(problems.first()[0] + "\n");
        }
    }
}
