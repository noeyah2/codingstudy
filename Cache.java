import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int ans = 0;
        final int HIT = 1;
        final int MISS = 5;

        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };

        for (String city : cities) {
            String c = city.toLowerCase();
            if (cache.containsKey(c)) {
                ans += HIT;
            } else {
                ans += MISS;
            }
            cache.put(c, true);
        }
        return ans;
    }
}
