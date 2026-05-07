import java.util.*; 
class Solution {
    int x, y, W, H;
    Map<Character, int[]> directions;
    public int[] solution(String[] park, String[] routes) {
        
        H = park.length; 
        W = park[0].length(); 
        directions = getDirections(); 
        setStartPoint(park); 
        
        
        StringTokenizer st; 
        for(int i = 0; i < routes.length; i++) {
            st = new StringTokenizer(routes[i]); 
            char op = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken()); 
            moveRobotDog(op, n, park); 
        }
        return new int[] {x, y};
    }
    
    private void moveRobotDog(char op, int n, String[] park) {
        int[] dir = directions.get(op); 
        int tmpx = x; 
        int tmpy = y; 
        for(int i = 0; i < n; i++) {
            int nx = tmpx + dir[0]; 
            int ny = tmpy + dir[1]; 
            if(nx < 0 || ny < 0 || nx >= H || ny >= W
               || park[nx].charAt(ny) == 'X') return; 
            tmpx = nx; 
            tmpy = ny; 
        }
        x = tmpx; 
        y = tmpy; 
    }
    
    private void setStartPoint(String[] park) {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i; 
                    y = j; 
                }
            }
        }
    }
    
    private Map<Character, int[]> getDirections() {
        Map<Character, int[]> directions = new HashMap<>(); 
        directions.put('N', new int[] {-1, 0}); 
        directions.put('S', new int[] {1, 0}); 
        directions.put('W', new int[] {0, -1}); 
        directions.put('E', new int[] {0, 1}); 
        return directions; 
    }
}