import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int start = 1;
    int end = 1;

    int cnt = 1;
    int sum = start;

    while (end != N) {
      if (sum == N) {
        cnt++;
        end++;
        sum = sum + end - start;
        start++;
      } else if (sum > N) {
        sum -= start;
        start++;
      } else {
        end++;
        sum += end;
      }
    }

    System.out.println(cnt);
  }
}
