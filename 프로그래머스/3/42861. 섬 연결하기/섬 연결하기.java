import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i = 0 ; i < n ; i++) parent[i] = i;
        
        int answer = 0;
        int edgeCnt = 0;
        
        for (int[] cost : costs) {
            int n1 = cost[0];
            int n2 = cost[1];
            int weight = cost[2];
            
            if (union(n1, n2)) {
                answer += weight;
                edgeCnt++;
            }
            
            if (edgeCnt == n-1) break;
        }
        
        return answer;
    }
    
    static int find (int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if (parentA == parentB) return false;
        parent[parentA] = parentB;
        return true;
    }
}