import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push":
          queue.offer(Integer.parseInt(st.nextToken()));
          break;

        case "pop":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.pop()).append("\n");
          }
          break;

        case "size":
          sb.append(queue.size()).append("\n");
          break;

        case "empty":
          sb.append(queue.isEmpty() ? 1 : 0).append("\n");
          break;

        case "front":
          sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
          break;

        case "back":
          sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
          break;

        default:
          break;
      }
    }

    System.out.println(sb.toString());
  }
}
