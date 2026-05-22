class Solution {
    int[][] computers;
    boolean[] visited;
    int n;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        this.visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int curr) {
        visited[curr] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[curr][i] == 1) {
                dfs(i);
            }
        }
    }
}