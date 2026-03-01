import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;

    StringBuilder sb = new StringBuilder();

    sb.append(fib(n)).append(' ');
    sb.append(fibonacci(n));

    System.out.println(sb.toString());
  }

  static int fib(int n) { // 재귀
    if (n == 1 || n == 2) {
      return 1;
    }
    return (fib(n - 1) + fib(n - 2));
  }

  static int fibonacci(int n) { // dp
    int cnt = 0;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
      cnt++;
    }
    return cnt;
  }
}
