import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, W;
  static int[][] dp; // dp[i][j] = i번째 물건까지 봤을 때, 용량j 가방의 최대 가치

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    int[] w = new int[N + 1];
    int[] v = new int[N + 1];

    dp = new int[N + 1][W + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      w[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) { // 물건을 하나씩 추가
      for (int j = 0; j <= W; j++) {
        if (j < w[i]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(
              dp[i - 1][j],
              v[i] + dp[i - 1][j - w[i]]
          );
        }
      }
    }

    System.out.println(dp[N][W]);
  }
}