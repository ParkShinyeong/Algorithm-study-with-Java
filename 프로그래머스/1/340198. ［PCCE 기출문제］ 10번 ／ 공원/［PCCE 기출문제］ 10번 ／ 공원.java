import java.util.*; 
class Solution {
    int n, m; 
    int[][] parkToInt;
    public int solution(int[] mats, String[][] park) {
        n = park.length; 
        m = park[0].length; 
        parkToInt = new int[n][m]; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                parkToInt[i][j] = park[i][j].charAt(0) - '-'; 
            }
        }
        int maxSize = 0; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(parkToInt[i][j] > 0) continue; 
                int size = getMaxDotjari(i, j, maxSize); 
                maxSize = Math.max(size, maxSize); 
            }
        }
          
        
        Arrays.sort(mats); 
        int idx = Arrays.binarySearch(mats, maxSize); 
        if(idx == -1) return -1;
        else if(idx < 0) return mats[-idx - 2]; 
        else return mats[idx]; 
    }
    
    private int getMaxDotjari(int sx, int sy, int maxSize) {
        int size = maxSize + 1; 
        while(true) {
            for(int i = sx; i < sx + size; i++) {
                for(int j = sy; j < sy + size; j++) {
                    if(i >= n || j >= m || parkToInt[i][j] > 0) {
                        return size - 1; 
                    }
                }
            }
            size++; 
        }
        // return size; 
    }
}