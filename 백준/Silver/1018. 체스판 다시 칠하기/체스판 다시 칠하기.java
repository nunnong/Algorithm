import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static char[][] tile;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int min = Integer.MAX_VALUE;

    tile = new char[N][M];

    for (int i = 0; i < N; i++) {
      tile[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        // 시작점 (i, j)
        cnt = 0;
        int w = start(i, j);

        if (min > w) {
          min = w;
        }
      }
    }

    System.out.println(min);

  }

  static int start(int startX, int startY) {
    for (int i = startX; i < startX + 8; i++) {
      for (int j = startY; j < startY + 8; j++) {
        if ((i + j) % 2 == 0 && tile[i][j] == 'B') {
          cnt++;
        }

        if ((i + j) % 2 == 1 && tile[i][j] == 'W') {
          cnt++;
        }
      }
    }
    return Math.min(cnt, 64 - cnt);
  }

}