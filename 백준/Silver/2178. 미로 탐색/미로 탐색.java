import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { 1, 0, -1, 0 };
  static int N, M;
  static int[][] graph;
  static Queue<int[]> q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N][M];
    q = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        graph[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs(0, 0));
  }

  static int bfs(int cx, int cy) {
    q.offer(new int[] { cx, cy });
    graph[cx][cy] = 1;

    while (!q.isEmpty()) {
      int[] current = q.poll();
      int x = current[0];
      int y = current[1];

      if (x == N - 1 && y == M - 1) {
        return graph[x][y];
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1) {
          q.offer(new int[] { nx, ny });
          graph[nx][ny] = graph[x][y] + 1;
        }
      }
    }

    return 0;
  }
}