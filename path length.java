import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};  // U, D, L, R
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        for (char dir : dirs.toCharArray()) {
            int d = -1;
            if (dir == 'U') d = 0;
            else if (dir == 'D') d = 1;
            else if (dir == 'L') d = 2;
            else if (dir == 'R') d = 3;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // 범위를 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 항상 작은 좌표 -> 큰 좌표 형태로 저장
            String path;
            if (x < nx || (x == nx && y < ny)) {
                path = x + "," + y + "->" + nx + "," + ny;
            } else {
                path = nx + "," + ny + "->" + x + "," + y;
            }
            
            visited.add(path);
            
            // 이동
            x = nx;
            y = ny;
        }
        
        return visited.size();
    }
}
path length
