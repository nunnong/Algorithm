import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    System.out.println(bfs(N, K));
  }

  static int bfs(int start, int target) {
    if (start == target)
      return 0;

    boolean[] visited = new boolean[100001];
    visited[start] = true;

    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    int cnt = 0;

    while (!q.isEmpty()) {
      cnt++;
      int size = q.size();

      while (size-- > 0) {
        int x = q.poll();

        for (int nx : new int[] { x - 1, x + 1, x * 2 }) {
          if (nx < 0 || nx >= 100001)
            continue;
          if (nx == target)
            return cnt;
          if (!visited[nx]) {
            visited[nx] = true;
            q.add(nx);
          }
        }
      }
    }

    return -1;
  }
}