class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        int tmpa = a; 
        int tmpb = b; 
        
        while(tmpa != tmpb) {
            tmpa = (tmpa / 2) + tmpa % 2; 
            tmpb = (tmpb / 2) + tmpb % 2; 
            answer++; 
        }

        return answer;
    }
}