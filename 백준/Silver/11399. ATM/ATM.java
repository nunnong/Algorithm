import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] times = new int[N];

    int sum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(times);

    for (int i = 0; i < N; i++) {
      sum += times[i] * (N - i);
    }

    System.out.println(sum);
  }
}