import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] dp = new int[31][31];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i <= 30; i++) {
      dp[i][0] = 1;
      dp[i][i] = 1;
    }

    for (int i = 1; i <= 30; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }

    StringTokenizer st;
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      System.out.println(dp[M][N]);
    }
  }
}
