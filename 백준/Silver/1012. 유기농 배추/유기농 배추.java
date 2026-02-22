import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int M, N, K;
  static int[][] graph;
  static int count = 0;

  public static void main(String[] arg) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      graph = new int[M][N];

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        graph[x][y] = 1;
      }

      count = 0;

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (graph[i][j] == 1) {
            bfs(i, j);
            count++;
          }
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb.toString());

  }

  static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();

    q.add(new int[] { x, y });
    graph[x][y] = 0;

    while (!q.isEmpty()) {
      int[] value = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = value[0] + dx[i];
        int ny = value[1] + dy[i];

        if (nx >= 0 && nx < M && ny >= 0 && ny < N && graph[nx][ny] == 1) {
          q.add(new int[] { nx, ny });
          graph[nx][ny] = 0;
        }
      }
    }

  }

}
