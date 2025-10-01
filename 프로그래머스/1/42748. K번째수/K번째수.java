import java.util.*; 
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i]; 
            int[] copyArr = new int[command[1] - command[0] + 1]; 
            
            System.arraycopy(array, command[0] - 1, copyArr, 0, command[1] - command[0] + 1); 
            Arrays.sort(copyArr); 
            answer[i] = copyArr[command[2] - 1]; 
        }
        return answer;
    }
}