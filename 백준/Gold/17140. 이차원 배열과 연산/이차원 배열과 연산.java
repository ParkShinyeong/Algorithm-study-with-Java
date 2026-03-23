import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k; 
    static int[][] table; 
    static int rowSize, colSize; 
    static HashMap<Integer, Integer> map = new HashMap<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        r = Integer.parseInt(st.nextToken()); 
        c = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 

        rowSize = 3; 
        colSize = 3; 

        table = new int[101][101]; 

        for(int i = 1; i <= colSize; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j = 1; j <= rowSize; j++) {
                table[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        bw.write(solution() + ""); 
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }

    private static int solution() {
        for(int time = 0; time <= 100; time++) {
            if(table[r][c] == k) return time; 
            if(colSize >= rowSize) calculateR(); 
            else calculateC(); 
        }
        return -1; 
    }

    private static void calculateR() {
        int maxLen = 0; 

        for(int i = 1; i <= colSize; i++) {
            map.clear(); 
            for(int j = 1; j <= rowSize; j++) {
                if(table[i][j] == 0) continue; 
                map.put(table[i][j], map.getOrDefault(table[i][j], 0) + 1); 
            }
            
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()); 
            Collections.sort(list, (a, b) -> {
                if(a.getValue() != b.getValue()) return a.getValue() - b.getValue(); 
                return a.getKey() - b.getKey(); 
            });
            int size = list.size() * 2 > 100 ? 100 : list.size() * 2; 
            int idx = 1; 
            for(int j = 0; j < list.size(); j++) {
                if(idx > 100) break; 
                table[i][idx++] = list.get(j).getKey(); 
                if(idx > 100) break; 
                table[i][idx++] = list.get(j).getValue();  
            }

            for(int j = size + 1; j <= 100; j++) {
                table[i][j] = 0; 
            }
            maxLen = Math.max(maxLen, size); 
        }
        rowSize = maxLen; 
    }

    private static void calculateC() {
        int maxLen = 0; 
        for(int i = 1; i <= rowSize; i++) {
            map.clear(); 
            for(int j = 1; j <= colSize; j++) {
                if(table[j][i] == 0) continue; 
                map.put(table[j][i], map.getOrDefault(table[j][i], 0) + 1); 
            }
            
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()); 
            Collections.sort(list, (a, b) -> {
                if(a.getValue() != b.getValue()) return a.getValue() - b.getValue(); 
                return a.getKey() - b.getKey(); 
            });

            int size = list.size() * 2 > 100 ? 100 : list.size() * 2; 
            int idx = 1; 
            for(int j = 0; j < list.size(); j++) {
                if(idx > 100) break; 
                table[idx++][i] = list.get(j).getKey(); 
                if(idx > 100) break; 
                table[idx++][i] = list.get(j).getValue();  
            }
            for(int j = size + 1; j <= 100; j++) {
                table[j][i] = 0; 
            }
            maxLen = Math.max(maxLen, size); 
        }
        colSize = maxLen;
    }
}
