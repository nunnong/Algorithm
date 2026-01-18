import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 구간합
    int[] sum = new int[N];
    sum[0] = arr[0];
    for (int i = 1; i < N; i++) {
      sum[i] = sum[i - 1] + arr[i];
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;

      if (start != 0) {
        System.out.println(sum[end] - sum[start - 1]);
      } else {
        System.out.println(sum[end]);
      }
    }

  }
}
