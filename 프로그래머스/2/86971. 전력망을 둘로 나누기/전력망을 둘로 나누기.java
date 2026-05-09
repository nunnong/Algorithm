import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] subtree;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        subtree = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, visited);

        int answer = n;
        for (int node = 2; node <= n; node++) {
            answer = Math.min(answer, Math.abs(subtree[node] - (n - subtree[node])));
        }

        return answer;
    }

    private void dfs(int node, boolean[] visited) {
        subtree[node] = 1;
        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited);
                subtree[node] += subtree[next];
            }
        }
    }
}