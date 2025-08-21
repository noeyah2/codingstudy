import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[][] dp;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        int n = sales.length;
        dp = new int[n+1][2];

        for (int[] link : links) {
            graph.computeIfAbsent(link[0], k -> new ArrayList<>()).add(link[1]);
        }

        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int node) {
        dp[node][0] = 0;        
        dp[node][1] = sales[node-1];

        if (!graph.containsKey(node)) return;
        
        int extra = Integer.MAX_VALUE;
        for (int child : graph.get(node)) {
            dfs(child);

            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            dp[node][0] += Math.min(dp[child][0], dp[child][1]);
            extra = Math.min(extra, dp[child][1] - Math.min(dp[child][0], dp[child][1]));
        }
        dp[node][0] += extra;
    }
}
