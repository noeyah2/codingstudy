import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();   // 중복 제거

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);

        int cnt = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                cnt++;
            }
        }

        return cnt;
    }

    // 순열 만들기
    private void dfs(String current, String numbers, boolean[] visited) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
