import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int t : tangerine) {
            hashmap.put(t, hashmap.getOrDefault(t, 0) + 1);
        }
    
        List<Integer> values = new ArrayList<>(hashmap.values());

        values.sort(Collections.reverseOrder());

        int answer = 0;
        for (int count : values) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}
