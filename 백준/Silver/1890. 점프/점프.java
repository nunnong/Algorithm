import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];

        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (dp[x][y] == 0) continue;

                if (x == N-1 && y == N-1) continue;

                int d = table[x][y];

                if (d == 0) continue;

                if ((x + d) < N) {
                    dp[x + d][y] += dp[x][y];
                }

                if ((y + d) < N) {
                    dp[x][y + d] += dp[x][y];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}