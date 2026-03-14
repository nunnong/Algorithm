import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];

    combi(1, 0);
    System.out.println(sb);
  }

  static void combi(int start, int cnt) {
    if (cnt == M) {
      for (int i = 1; i <= N; i++) {
        if (visited[i]) {
          sb.append(i).append(" ");
        }
      }
      sb.append("\n");
    }

    for (int i = start; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combi(i + 1, cnt + 1);
        visited[i] = false;
      }
    }
  }
}