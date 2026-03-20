import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[][] graph = new int[N][N];
    boolean[][] snake = new boolean[N][N]; // 몸통 위치

    StringTokenizer st;
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      graph[r][c] = 1;
    }

    int L = Integer.parseInt(br.readLine());
    int[] turnTime = new int[L];
    char[] turnDir = new char[L];
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      turnTime[i] = Integer.parseInt(st.nextToken());
      turnDir[i] = st.nextToken().charAt(0);
    }

    Deque<int[]> deque = new ArrayDeque<>();
    deque.addFirst(new int[] { 0, 0 });
    snake[0][0] = true;

    int dir = 1;
    int time = 0;
    int turnIdx = 0;

    while (true) {
      time++;

      // 머리 이동
      int[] head = deque.peekFirst();
      int nx = head[0] + dx[dir];
      int ny = head[1] + dy[dir];

      // 벽 충돌 또는 몸통 충돌
      if (nx < 0 || nx >= N || ny < 0 || ny >= N || snake[nx][ny]) {
        break;
      }

      if (graph[nx][ny] == 1) {
        graph[nx][ny] = 0; // 사과 먹음
      } else {
        int[] tail = deque.pollLast();
        snake[tail[0]][tail[1]] = false;
      }

      deque.addFirst(new int[] { nx, ny });
      snake[nx][ny] = true;

      // 방향 전환
      if (turnIdx < L && time == turnTime[turnIdx]) {
        if (turnDir[turnIdx] == 'D') {
          dir = (dir + 1) % 4;
        } else {
          dir = (dir + 3) % 4;
        }
        turnIdx++;
      }
    }

    System.out.println(time);
  }
}