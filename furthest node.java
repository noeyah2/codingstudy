import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }

        int maxDist = 0;
        for (int d : distance) {
            if (d > maxDist) {
                maxDist = d;
            }
        }

        for (int d : distance) {
            if (d == maxDist) {
                answer++;
            }
        }

        return answer;
    }
}
