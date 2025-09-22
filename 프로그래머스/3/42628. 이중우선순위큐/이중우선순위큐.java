import java.util.*; 
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        StringTokenizer st; 
        
        TreeSet<Integer> list = new TreeSet<>(); 
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]); 
            String operation = st.nextToken(); 
            int data = Integer.parseInt(st.nextToken()); 
            // PriorityQueue<Integer> minQueue = new PriorityQueue<>(); 
            // PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a); 
            // Map<Integer, Integer> isExisted = new HashMap<>(); 
            switch (operation.charAt(0)) {
                case 'D':
                    if(data == 1) { // 최댓값 삭제 
                        if(list.size() > 0)
                            list.remove(list.last()); 
                        
                    } else { // 최솟값 삭제 
                        if(list.size() > 0) 
                            list.remove(list.first()); 
                    }
                    break; 
                case 'I':
                    list.add(data);  
                    break; 
            }
        }
        
        if(list.size() == 0) return new int[] {0, 0}; 
        
        return new int[] {list.last(), list.first()};
    }
}