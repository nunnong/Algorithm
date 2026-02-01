import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      graph[s].add(e);
      graph[e].add(s);
    }

    int cnt = 0; // 연결 요소 개수
    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }
      cnt++;
      DFS(i);
    }

    System.out.println(cnt);
  }

  public static void DFS(int i) {
    visited[i] = true;
    for (int k : graph[i]) {
      if (!visited[k]) {
        DFS(k);
      }
    }
  }
}