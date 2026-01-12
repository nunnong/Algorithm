import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine()); // 명령의 수 N
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {

      st = new StringTokenizer(br.readLine());

      String nextToken = st.nextToken();

      if (nextToken.equals("push")) {
        stack.push(Integer.parseInt(st.nextToken()));
        continue;
      }

      if (nextToken.equals("pop")) {
        System.out.println(stack.isEmpty() ? -1 : stack.pop());
        continue;
      }

      if (nextToken.equals("size")) {
        System.out.println(stack.size());
        continue;
      }

      if (nextToken.equals("empty")) {
        System.out.println(stack.isEmpty() ? 1 : 0);
        continue;
      }

      if (nextToken.equals("top")) {
        System.out.println(stack.isEmpty() ? -1 : stack.peek());

      }

    }

  }
}
