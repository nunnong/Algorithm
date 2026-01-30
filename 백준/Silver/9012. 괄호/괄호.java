import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      char[] arr = br.readLine().toCharArray();

      Deque<Character> deque = new ArrayDeque<>();
      boolean isVPS = true;

      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == '(') {
          deque.add('(');
          continue;
        }
        if (deque.isEmpty()) {
          isVPS = false;
          break;
        } else {
          deque.pollLast();
        }
      }

      if (!deque.isEmpty()) {
        isVPS = false;
      }

      if (isVPS) {
        sb.append("YES").append("\n");
      } else {
        sb.append("NO").append("\n");
      }
    }

    System.out.println(sb.toString());

  }
}
