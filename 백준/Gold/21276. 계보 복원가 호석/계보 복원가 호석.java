import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws IOException {
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 
        st = new StringTokenizer(br.readLine()); 
        HashMap<String, ArrayList<String>> ancestor = new HashMap<>(); 
        HashMap<String, ArrayList<String>> child = new HashMap<>(); 


        for(int i = 0; i < N; i++) {
        	String str = st.nextToken(); 
            ancestor.put(str, new ArrayList<>()); 
            child.put(str, new ArrayList<>()); 
        }

        int M = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            String c = st.nextToken(); 
            String a = st.nextToken(); 
            ancestor.get(c).add(a); 
        }
        HashMap<String, ArrayList<String>> childs = getChild(N, ancestor, child); 
        getAnswer(childs);
    }
    static void getAnswer(HashMap<String, ArrayList<String>> child) throws IOException {
        HashMap<String, Integer> childIndegrees = getIndegree(child);
        int cnt = 0; 
        StringBuilder sb = new StringBuilder(); 
        for(String key: childIndegrees.keySet()) {
            int value = childIndegrees.get(key); 
            if(value == 0)  {
                sb.append(key).append(" "); 
                cnt++; 
            }
        }
        String firstAncestor = sb.append("\n").toString(); 
        bw.write(cnt + "\n"); 
        bw.write(firstAncestor); 
        ArrayList<String> arr = new ArrayList<>(); 
        for(String key: child.keySet()) {
            sb = new StringBuilder(); 
            sb.append(key).append(" ") 
                .append(child.get(key).size()).append(" ");
                Collections.sort(child.get(key), (a, b) -> a.compareTo(b)); 
            for(String c: child.get(key)) {
                sb.append(c).append(" "); 
            } 
            sb.append("\n");
            arr.add(sb.toString());  
        }

        Collections.sort(arr, (a, b) -> a.compareTo(b)); 
        for(String str: arr) {
            bw.write(str); 
        }
        bw.flush();
        bw.close(); 
        br.close();
    }

    static HashMap<String, ArrayList<String>> getChild(int N, HashMap<String, ArrayList<String>> ancestor, HashMap<String, ArrayList<String>> child) {
        HashMap<String, Integer> indegrees = getIndegree(ancestor); 
        Queue<String> q = new ArrayDeque<>(); 
        for(String key: indegrees.keySet()) {
            if(indegrees.get(key) == 0) q.offer(key); 
        }
        while(!q.isEmpty()) {
            String tmp = q.poll(); 
            for(String ances: ancestor.get(tmp)) {
                indegrees.put(ances, indegrees.get(ances) - 1); 
                if(indegrees.get(ances) == 0 || ancestor.get(tmp).size() == 1) {
                    // 부모인 경우 
                    child.get(ances).add(tmp); 
                } 
                if(indegrees.get(ances) == 0) q.offer(ances); 
            }
        }
        return child; 
    }
    static HashMap<String, Integer> getIndegree(HashMap<String, ArrayList<String>> graph) {
        HashMap<String, Integer> indegrees = new HashMap<>(); 
        for(String key: graph.keySet()) {
            indegrees.put(key, 0);
        }
        for(String key: graph.keySet()) {
            for(String anc : graph.get(key)) {
                indegrees.put(anc, indegrees.get(anc) + 1); 
            }
        }
        return indegrees; 
    }
}
