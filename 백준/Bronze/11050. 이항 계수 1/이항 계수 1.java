import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");

    int N = Integer.parseInt(line[0]);
    int K = Integer.parseInt(line[1]);

    // N개 중에 K개 선택하기

    int[][] dp = new int[N + 1][N + 1];

    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
      dp[i][i] = 1;
      dp[i][1] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }

    System.out.println(dp[N][K]);
  }

}