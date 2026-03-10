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
        StringBuilder answer = new StringBuilder(); 
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
                    if(x == 1) answer.append(problemWithSort.get(sort).last().num).append("\n"); 
                    else answer.append(problemWithSort.get(sort).first().num).append("\n"); 
                    break; 
                case "recommend2": 
                    x = Integer.parseInt(st.nextToken()); 
                    if(x == 1) answer.append(problems.last().num).append("\n"); 
                    else answer.append(problems.first().num).append("\n"); 
                    break; 
                case "recommend3" : 
                    x = Integer.parseInt(st.nextToken()); 
                    int L = Integer.parseInt(st.nextToken()); 
                    if(x == 1) {
                        Problem p = problems.ceiling(new Problem(0, L, 0)); 
                        if(p == null) answer.append("-1").append("\n"); 
                        else answer.append(p.num).append("\n");  
                    } else {
                        Problem p = problems.floor(new Problem(0, L, 0)); 
                        if(p == null) answer.append("-1").append("\n");  
                        else answer.append(p.num).append("\n");  
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

        bw.write(answer.toString()); 
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
        if(this.lv != o.lv) return this.lv - o.lv; // 1순위 난이도
        if(this.num != o.num) return this.num - o.num; // 2순위 문제 번호 
        return this.sort - o.sort; // 3순위 알고리즘 분류 
    }
}