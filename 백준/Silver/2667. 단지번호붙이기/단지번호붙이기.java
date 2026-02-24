import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static Queue<int[]> q = new ArrayDeque<>();
  static boolean[][] graph;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    graph = new boolean[N][N];
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      char[] c = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        graph[i][j] = c[j] - '0' == 1 ? true : false;
      }
    }
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (graph[i][j]) {
          list.add(bfs(i, j));
          count++;
        }
      }
    }
    Collections.sort(list);

    System.out.println(count);
    for (int i : list) {
      System.out.println(i);
    }

  }

  static int bfs(int x, int y) {
    int cnt = 1;
    q.add(new int[] { x, y });
    graph[x][y] = false;

    while (!q.isEmpty()) {
      int[] point = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = point[0] + dx[i];
        int ny = point[1] + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny]) {
          q.add(new int[] { nx, ny });
          graph[nx][ny] = false;
          cnt++;
        }
      }
    }

    return cnt;
  }
}
