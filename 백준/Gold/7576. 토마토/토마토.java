import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int days = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    Deque<int[]> q = new ArrayDeque<>();

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] box = new int[N][M];

    boolean tomatoDone = true;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if (box[i][j] == 1) {
          q.add(new int[] { i, j, 0 });
        } else {
          tomatoDone = false;
        }
      }
    }

    if (tomatoDone) {
      System.out.println(0);
    } else {

      while (!q.isEmpty()) {
        int[] arr = q.poll();

        int x1 = arr[0];
        int y1 = arr[1];
        days = arr[2];

        for (int i = 0; i < 4; i++) {
          int nx = x1 + dx[i];
          int ny = y1 + dy[i];

          if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
            q.add(new int[] { nx, ny, days + 1 });
            box[nx][ny] = 1;
          }
        }

      }
      boolean notRiped = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (box[i][j] == 0) {
            notRiped = true;
            break;
          }
        }
      }
      System.out.println(notRiped ? -1 : days);

    }

  }
}