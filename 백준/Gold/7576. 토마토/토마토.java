import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] box = new int[N][M];
    Queue<int[]> q = new ArrayDeque<>(); 
    boolean hasUnripe = false;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if (box[i][j] == 1) {
          q.add(new int[] { i, j, 0 });
        } else if (box[i][j] == 0) { 
          hasUnripe = true;
        }
      }
    }

    if (!hasUnripe) {
      System.out.println(0);
      return;
    }

    int days = 0;
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0], y = cur[1];
      days = cur[2];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
          box[nx][ny] = 1;
          q.add(new int[] { nx, ny, days + 1 });
        }
      }
    }

    // 아직 안 익은 토마토 확인
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (box[i][j] == 0) {
          System.out.println(-1);
          return;
        }

    System.out.println(days);
  }
}