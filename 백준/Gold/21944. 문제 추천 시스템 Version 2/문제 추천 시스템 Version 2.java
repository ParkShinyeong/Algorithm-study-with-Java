import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static TreeSet<Problem> problems; 
    static HashMap<Integer, TreeSet<Problem>> problemWithSort; 
    static HashMap<Integer, Problem> info; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 
        problems = new TreeSet<>(); 
        problemWithSort = new HashMap<>();
        info = new HashMap<>(); 

        StringTokenizer st; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int num = Integer.parseInt(st.nextToken()); 
            int lv = Integer.parseInt(st.nextToken()); 
            int sort = Integer.parseInt(st.nextToken()); 
            insertProblem(num, lv, sort); 
        }

        M = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            String command = st.nextToken(); 
            switch(command) {
                case "add":
                    int num = Integer.parseInt(st.nextToken()); 
                    int lv = Integer.parseInt(st.nextToken()); 
                    int sort = Integer.parseInt(st.nextToken()); 
                    insertProblem(num, lv, sort); 
                    break; 
                case "recommend": 
                    sort = Integer.parseInt(st.nextToken()); 
                    int x = Integer.parseInt(st.nextToken()); 
                    if(x == 1) bw.write(problemWithSort.get(sort).last().num + "\n"); 
                    else bw.write(problemWithSort.get(sort).first().num + "\n"); 
                    break; 
                case "recommend2": 
                    x = Integer.parseInt(st.nextToken()); 
                    if(x == 1) bw.write(problems.last().num + "\n"); 
                    else bw.write(problems.first().num + "\n"); 
                    break; 
                case "recommend3" : 
                    x = Integer.parseInt(st.nextToken()); 
                    int L = Integer.parseInt(st.nextToken()); 
                    if(x == 1) {
                        Problem p = problems.ceiling(new Problem(0, L, 0)); 
                        if(p == null) bw.write("-1" + "\n"); 
                        else bw.write(p.num + "\n"); 
                    } else {
                        Problem p = problems.floor(new Problem(0, L, 0)); 
                        if(p == null) bw.write("-1" + "\n"); 
                        else bw.write(p.num + "\n"); 
                    }
                    break; 
                case "solved": 
                    int P = Integer.parseInt(st.nextToken()); 
                    Problem p = info.get(P); 
                    problems.remove(p); 
                    problemWithSort.get(p.sort).remove(p); 
                    info.remove(P); 
                    break; 
            }
        }
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static void insertProblem(int num, int lv, int sort) {
        Problem tmp = new Problem(num, lv, sort); 
        problems.add(tmp); 
        problemWithSort.put(sort, problemWithSort.getOrDefault(sort, new TreeSet<>())); 
        problemWithSort.get(sort).add(tmp); 
        info.put(num, tmp); 
    }
}

class Problem implements Comparable<Problem> {
    int num, lv, sort; 
    Problem (int num, int lv, int sort) {
        this.num = num; 
        this.lv = lv; 
        this.sort = sort; 
    }

    @Override
    public int compareTo(Problem o) {
        if(this.lv == o.lv) return this.num - o.num; 
        return this.lv - o.lv; 
    }
}