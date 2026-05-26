class Solution {
    int[] discountRate = {10, 20, 30, 40}; 
    int[] emoticons; 
    int[][] users; 
    int cnt = 0, price = 0; 
    public int[] solution(int[][] users, int[] emoticons) {
        this.emoticons = emoticons; 
        this.users = users; 
        
        dfs(0, new int[emoticons.length]); 
        
        return new int[] {cnt, price};
    }
    
    private void dfs(int idx, int[] discount) {
        if(idx == emoticons.length) {
            // 고객의 이모티콘 구매 여부..? 계산? 
            int[] ans = getBuyer(discount);
            if(cnt < ans[0]) {
                cnt = ans[0]; 
                price = ans[1]; 
            } else if(cnt == ans[0]){
                price = Math.max(price, ans[1]); 
            }
            return; 
        }
        
        for(int i = 0; i < 4; i++) {
            discount[idx] = discountRate[i]; 
            dfs(idx + 1, discount); 
        }   
    }
    
    private int[] getBuyer(int[] discount) {
        int[] prices = new int[users.length]; 
        for(int i = 0; i < discount.length; i++) {
            for(int j = 0; j < users.length; j++) {
                if(discount[i] < users[j][0]) continue; 
                prices[j] += (emoticons[i] * (100 - discount[i])) / 100; 
            }
        }
        
        int cnt = 0; 
        int price = 0; 
        for(int i = 0; i < users.length; i++) {
            if(prices[i] >= users[i][1]) cnt++;
            else price += prices[i]; 
        }
        return new int[] {cnt, price}; 
    }
}