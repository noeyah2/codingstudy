import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int ans = 0;
        
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        
        for(int i=0 ; i<priorities.length ; i++) {
            queue.offer(new AbstractMap.SimpleEntry<>(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();

            boolean hasHigher = false;
            for (Map.Entry<Integer, Integer> e : queue) {
                if (e.getValue() > entry.getValue()) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(entry);
            } else {
                ans++;
                if (entry.getKey() == location) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
