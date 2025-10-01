import java.util.*; 
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i]; 
            int st = command[0]; 
            int end = command[1]; 
            int cnt = command[2]; 
            
            int[] arr = new int[end - st + 1]; 
            for(int j = 0 ; j < end - st + 1; j++) {
                arr[j] = array[j + st - 1]; 
            }
            
            Arrays.sort(arr); 
            answer[i] = arr[cnt - 1]; 
        }
        return answer;
    }
}