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
    for (int i = 1; i <= N; i++) {
      q.add(i);
    }

    StringBuilder sb = new StringBuilder(N * 4);
    sb.append('<');

    while (!q.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        q.add(q.poll());
      }

      sb.append(q.poll());
      if (!q.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append('>');
    System.out.println(sb);
  }
}