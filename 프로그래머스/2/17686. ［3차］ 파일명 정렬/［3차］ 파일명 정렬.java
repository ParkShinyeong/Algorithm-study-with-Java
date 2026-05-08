import java.util.*; 
class Solution {
    public String[] solution(String[] files) {
        int len = files.length; 
        String[] answer = new String[len];
        
        FileName[] filenames = new FileName[len]; 
        for(int i = 0; i < len; i++) {
            filenames[i] = new FileName(files[i]);
        }
        
        Arrays.sort(filenames); 
        
        for(int i = 0; i < len; i++) {
            answer[i] = filenames[i].full; 
        }
        
        return answer;
    }
}

class FileName implements Comparable<FileName>{
    String head, tail, full; 
    int num;
    
    FileName(String name) {
        // head, num, tail로 구분해야 함. 
        full = name; 
        head = tail = ""; 
        String numstr = ""; 
        
        boolean isTail = false; 
        for(char c: name.toCharArray()) {
            int tmp = c - '0'; 
            if(0 <= tmp && tmp <= 9) {
                if(!isTail) numstr += tmp; 
                else tail += c; 
            } else {
                if(isTail || numstr.length() != 0) {
                    tail += c; 
                    isTail = true; 
                } else head += c; 
            }
        }
        
        tail = tail.toUpperCase(); 
        head = head.toUpperCase(); 
        num = Integer.parseInt(numstr); 
    }
    
    @Override
    public int compareTo(FileName o) {
        if(!this.head.equals(o.head)) return this.head.compareTo(o.head);
        else if(this.num != o.num) return Integer.compare(this.num, o.num); 
        return 0;
    }
}