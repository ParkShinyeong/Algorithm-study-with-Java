import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws IOException {
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 
        st = new StringTokenizer(br.readLine()); 
        HashMap<String, ArrayList<String>> graph = new HashMap<>(); 

        for(int i = 0; i < N; i++) {
        	graph.put(st.nextToken(), new ArrayList<>()); 
        }

        int M = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); 
            String c = st.nextToken(); 
            String a = st.nextToken(); 
            graph.get(a).add(c); 
        }
        HashMap<String, ArrayList<String>> childs = getChild(N, graph); 
        getAnswer(graph, childs);
    }
    
    static void getAnswer(HashMap<String, ArrayList<String>> graph, HashMap<String, ArrayList<String>> child) throws IOException {
        HashMap<String, Integer> indegrees = getIndegree(graph);
        int cnt = 0; 
        StringBuilder sb = new StringBuilder(); 
        for(String key: indegrees.keySet()) {
            int value = indegrees.get(key); 
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


    static HashMap<String, ArrayList<String>> getChild(int N, HashMap<String, ArrayList<String>> graph) {
    	HashMap<String, ArrayList<String>> childrens = new HashMap<String, ArrayList<String>>();
    	for(String key: graph.keySet()) {
    		childrens.put(key, new ArrayList<String>()); 
    	}
    	HashMap<String, Integer> indegrees = getIndegree(graph); 
    	Queue<String> q = new ArrayDeque<>(); 
    	for(String key: indegrees.keySet()) {
    		if(indegrees.get(key) == 0) q.offer(key); 
    	}
    	
    	while(!q.isEmpty()) {
    		String tmp = q.poll(); 
    		for(String child: graph.get(tmp)) {
    			indegrees.put(child, indegrees.get(child) - 1); 
    			if(indegrees.get(child) == 0) { 
    				q.offer(child);
    				childrens.get(tmp).add(child);  
    			}
    		}
    	}
    	return childrens; 
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
