import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayDeque<Integer> st = new ArrayDeque<>(); 
        for(int num : arr) {
            if(st.isEmpty() || st.peekLast() != num) {
                st.add(num); 
            }
        }
        
        return st.stream()
            .mapToInt(Integer::valueOf)
            .toArray(); 
    }
}