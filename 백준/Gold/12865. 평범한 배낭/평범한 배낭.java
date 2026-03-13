import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int[] weights;
  static int[] values;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    weights = new int[N];
    values = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i] = Integer.parseInt(st.nextToken());
      values[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= K; j++) {
        dp[i][j] = dp[i-1][j];

        if (j >= weights[i-1]) {
          dp[i][j] = Math.max(dp[i][j], dp[i-1][j - weights[i-1]] + values[i-1]);
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}
