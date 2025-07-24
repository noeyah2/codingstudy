import java.util.*;

class Solution {
    int maxCnt = 0;
    
    public int solution(int k, int[][] dun) {
        boolean[] visited = new boolean[dun.length];
        
        dfs(k, visited, 0, dun);
        
        return maxCnt;
    }
    
    void dfs(int cur, boolean[] visited, int cnt, int[][] dun){
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int i=0 ; i<dun.length ; i++){
            int req = dun[i][0];
            int cost = dun[i][1];
            
            if(!visited[i] && req <= cur){
                visited[i] = true;
                dfs(cur - cost, visited, cnt+1, dun);
                visited[i] = false;
                
            }
        }
    }
}
