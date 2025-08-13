import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] test3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == test1[i % test1.length]) cnt1++;
            if (answers[i] == test2[i % test2.length]) cnt2++;
            if (answers[i] == test3[i % test3.length]) cnt3++;
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> list = new ArrayList<>();
        
        if (cnt1 == max) list.add(1);
        if (cnt2 == max) list.add(2);
        if (cnt3 == max) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
