import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> isParticipant = new HashMap<>(); 
        
        for(String pt: participant) {
            isParticipant.put(pt, isParticipant.getOrDefault(pt, 0) + 1); 
        }
        
        for(String cp: completion) {
            isParticipant.put(cp, isParticipant.get(cp) - 1); 
        }
        
        for(String s : isParticipant.keySet()) {
            if(isParticipant.get(s) > 0) return s; 
        }
        
        return answer;
    }
}