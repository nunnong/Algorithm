import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M, R, order = 1;
  static List<Integer>[] graph;
  static int[] checked;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    checked = new int[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    checked[R] = order++;
    dfs(R);

    for (int i = 1; i <= N; i++) {
      System.out.println(checked[i]);
    }

  }

  static void dfs(int start) {
    Collections.sort(graph[start]);
    boolean next = false;

    for (int i : graph[start]) {
      if (checked[i] == 0) {
        checked[i] = order++;
        next = true;
        dfs(i);
      }
    }

    if (!next) {
      return;
    }
  }
}
