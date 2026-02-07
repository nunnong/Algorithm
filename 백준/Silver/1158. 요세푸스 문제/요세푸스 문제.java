import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);

    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      q.add(i + 1);
    }
    StringBuilder sb = new StringBuilder();
    int k = K;

    while (!q.isEmpty()) {
      k = K;
      while (--k > 0) {
        int add = q.poll();
        q.add(add);
      }
      sb.append(q.poll()).append(',').append(" ");
    }

    sb.insert(0, "<");
    sb.setLength(sb.length() - 2);
    sb.append(">");

    System.out.println(sb.toString());

  }
}
