import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            boolean ruleBroken = prev.charAt(prev.length() - 1) != curr.charAt(0);
            boolean duplicate = !used.add(curr); // add 실패 시 true

            if (ruleBroken || duplicate) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
        }
        return new int[]{0, 0};
    }
}
