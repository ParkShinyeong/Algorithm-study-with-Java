import java.util.*; 
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] citationObj = Arrays.stream(citations)
            .boxed()
            .toArray(Integer[]::new); 
        Arrays.sort(citationObj, Collections.reverseOrder()); 
        
        // for(int i = 0; i < citationObj.length ; i++) {
        //     int tmp = citationObj[i]; 
        //     if(i + 1 >= tmp && citationObj.length - i - 1 <= tmp) return tmp; 
        // }
        
        for(int i = citationObj[0]; i >= 0; i--) {
            int upper = 0; 
            int lower = 0; 
            for(int j = 0; j < citationObj.length; j++) {
                if(citationObj[j] >= i) upper++; 
                else lower++; 
            }
            if(upper >= i && lower <= i) return i; 
        }
        return answer;
    }
}