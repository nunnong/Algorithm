import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static boolean[] visited;
  static int N, M;
  static int[] result;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];
    arr = new int[N];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    permutation(0);

    System.out.println(sb);
  }

  static void permutation(int cnt) {
    if (cnt == M) {
      for (int i : result) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    int lastUsed = 0;
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        if (lastUsed == arr[i])
          continue;
        lastUsed = arr[i];
        visited[i] = true;
        result[cnt] = arr[i];
        permutation(cnt + 1);
        visited[i] = false;
      }
    }
  }
}