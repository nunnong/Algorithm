import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine()); // 명령의 수 N
    Deque<Integer> stack = new ArrayDeque<>();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {

      st = new StringTokenizer(br.readLine());

      String nextToken = st.nextToken();

      if (nextToken.equals("push")) {
        stack.push(Integer.parseInt(st.nextToken()));
        continue;
      }

      if (nextToken.equals("pop")) {

        sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
        continue;
      }

      if (nextToken.equals("size")) {
        sb.append(stack.size()).append("\n");
        continue;
      }

      if (nextToken.equals("empty")) {
        sb.append(stack.isEmpty() ? 1 : 0).append("\n");
        continue;
      }

      if (nextToken.equals("top")) {
        sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
      }

    }

    System.out.println(sb.toString());

  }
}
