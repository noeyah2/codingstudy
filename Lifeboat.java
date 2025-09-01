// people 배열을 정렬한다. (가벝 → 무겁)
// 가장 가벼운 사람(left)과 가장 무거운 사람(right)을 비교한다.
// 둘의 합이 limit 이하라면 같이 태울 수 있으니까 left++, right--.
// 초과하면 무거운 사람 혼자만 보트에 태우고 right--.
// 매번 보트 카운트를 cnt++ 해준다.
// 모든 사람이 태워질 때까지 반복.
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0; 
        int right = people.length - 1;
        int cnt = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            cnt++;
        }
        return cnt;        
    }
}
