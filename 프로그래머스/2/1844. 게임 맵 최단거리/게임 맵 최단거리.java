import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    int[] dy = {0, 0, -1, 1};
    int[][] maps;
    boolean[][] visited;
    int answer = -1;
    int m, n;
    
    Queue<int[]> q = new ArrayDeque<>();
    
    public int solution(int[][] maps) {
        
        this.maps = maps;
        m = maps.length;
        n = maps[0].length;
        
        visited = new boolean[m][n];
        
        q.offer(new int[]{0,0,1}); // x좌표, y좌표, depth
        visited[0][0] = true;
        bfs();
        
        return answer;
    }
    
    void bfs() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int depth = curr[2];
            
            if (cx == m -1 && cy == n -1) {
                answer = depth;
                return;
            }
            
            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny, depth+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    
}