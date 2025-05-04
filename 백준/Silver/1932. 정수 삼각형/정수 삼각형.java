import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        dp[0][0] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + tmp;
                }
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + tmp;
                }

                if (j > 0 && j < i) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tmp;
                }

            }

        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);
    }
}
