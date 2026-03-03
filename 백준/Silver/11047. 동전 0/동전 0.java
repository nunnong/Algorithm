import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] value = new int[N];

    for (int i = 0; i < N; i++) {
      value[i] = Integer.parseInt(br.readLine());
    }

    int totalCnt = 0;
    int sum = K;

    for (int i = N - 1; i >= 0; i--) {
      int cnt = 0;
      cnt += sum / value[i];
      totalCnt += cnt;
      sum -= value[i] * cnt;
    }

    System.out.println(totalCnt);

  }
}