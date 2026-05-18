import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int[] p : puddles) {
            dp[p[0] - 1][p[1] - 1] = -1;
        }
        
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (dp[i][j] == -1) continue;
                
                if (i-1 >= 0 && dp[i-1][j] != -1) {
                    dp[i][j] += dp[i-1][j];
                }
                
                if (j-1 >= 0 && dp[i][j-1] != -1) {
                    dp[i][j] += dp[i][j-1];
                }
                
                dp[i][j] %= 1000000007;
            }
        }
        
        return dp[m-1][n-1];
    }
}