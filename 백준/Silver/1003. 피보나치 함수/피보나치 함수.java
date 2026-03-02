import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    // fibonacci(0), fibonacci(1)을 각각 몇 번 호출하는지 체크하기.

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());

      if (N == 0) {
        sb.append(1).append(" ").append(0).append("\n");
        continue;
      }

      if (N == 1) {
        sb.append(0).append(" ").append(1).append("\n");
        continue;
      }

      int[] one = new int[N + 1];
      int[] zero = new int[N + 1];

      zero[0] = 1;
      zero[1] = 0;

      one[0] = 0;
      one[1] = 1;

      for (int i = 2; i <= N; i++) {
        zero[i] = zero[i - 2] + zero[i - 1];
        one[i] = one[i - 2] + one[i - 1];
      }
      sb.append(zero[N]).append(" ").append(one[N]).append("\n");
    }

    System.out.println(sb.toString());

  }
}