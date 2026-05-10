import java.util.*; 
class Solution {
    public int solution(int[] num_list, int n) {
        Arrays.sort(num_list); 
        int isExist = Arrays.binarySearch(num_list, n);
        // System.out.println(isExist); 
        return isExist >= 0 ? 1 : 0;
    }
}