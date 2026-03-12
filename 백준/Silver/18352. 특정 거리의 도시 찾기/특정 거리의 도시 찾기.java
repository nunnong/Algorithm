import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    List<Integer>[] graph = new ArrayList[N + 1];

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph[s].add(e);
    }

    boolean[] visited = new boolean[N + 1];
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[] { X, 0 });
    visited[X] = true;

    List<Integer> list = new ArrayList<>();

    while (!q.isEmpty()) {

      int[] curr = q.poll();
      int node = curr[0];
      int cnt = curr[1];

      if (cnt == K) {
        list.add(node);
      }

      for (int i : graph[node]) {
        if (!visited[i]) {
          visited[i] = true;
          q.add(new int[] { i, cnt + 1 });
        }
      }
    }
    if (list.isEmpty()) {
      System.out.println(-1);
      return;
    }

    Collections.sort(list);
    for (int i : list) {
      sb.append(i).append("\n");
    }

    System.out.println(sb.toString());
  }
}
