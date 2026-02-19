import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static boolean[] checked;
  static int count = 0;
  static List<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    graph = new ArrayList[N + 1];
    StringTokenizer st;
    checked = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    bfs(1);
    System.out.println(count);

  }

  static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    checked[start] = true;

    while (!q.isEmpty()) {
      int num = q.poll();

      for (int i : graph[num]) {
        if (!checked[i]) {
          checked[i] = true;
          q.add(i);
          count++;
        }
      }
    }

  }
}
