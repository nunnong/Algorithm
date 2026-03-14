import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];

    combi(1, 0);
    System.out.println(sb);
  }

  static void combi(int start, int cnt) {
    if (cnt == M) {
      for (int i = 0; i < M; i++) { // i는 1부터 시작하면 안 됨
        sb.append(arr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i <= N; i++) {
      arr[cnt] = i;
      combi(i + 1, cnt + 1);
    }
  }
}