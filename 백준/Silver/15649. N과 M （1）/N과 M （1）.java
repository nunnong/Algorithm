import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static boolean[] checked;
  static StringBuilder sb;
  static int[] selected;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    String[] line = br.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);

    checked = new boolean[N + 1];
    selected = new int[M];

    combination(0);
    System.out.println(sb.toString());
  }

  public static void combination(int cnt) {
    if (cnt == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!checked[i]) {
        checked[i] = true;
        selected[cnt] = i;
        combination(cnt + 1);
        checked[i] = false;
      }

    }
  }
}