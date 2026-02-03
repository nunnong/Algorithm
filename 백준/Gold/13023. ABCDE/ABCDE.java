import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static boolean exist = false;
  static ArrayList<Integer>[] list;
  static boolean[] visited;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      list[n1].add(n2);
      list[n2].add(n1);
    }

    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      dfs(i, 1);
      visited[i] = false;

      if (exist) break;
    }

    System.out.println(exist ? 1 : 0);
  }

  static void dfs(int node, int depth) {
    if (exist) return;

    if (depth == 5) {
      exist = true;
      return;
    }

    for (int next : list[node]) {
      if (!visited[next]) {
        visited[next] = true;
        dfs(next, depth + 1);
        visited[next] = false;
      }
    }
  }
}
