import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new); 
        
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b)); 
        
        if(nums[0].equals("0")) return "0"; 
        return String.join("", nums);
    }
}