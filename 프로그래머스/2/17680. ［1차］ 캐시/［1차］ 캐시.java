import java.util.*; 
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5; 
        
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize; 
            }
        };
        
        for(String city: cities) {
            String cityupper = city.toUpperCase(); 
            
            if(cache.containsKey(cityupper)) {
                answer++; 
                cache.get(cityupper); 
            } else {
                answer += 5; 
                cache.put(cityupper, 0); 
            }
        }
        return answer;
    }
}