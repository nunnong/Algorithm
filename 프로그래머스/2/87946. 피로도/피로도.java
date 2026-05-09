class Solution {
    int answer = 0;
    int[][] dungeons;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        dfs(k, 0);
        return answer;
    }
    
    private void dfs(int power, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && power >= dungeons[i][0]) {
                visited[i] = true;
                dfs(power - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}