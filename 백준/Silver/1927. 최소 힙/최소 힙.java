import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    while (N-- > 0) {
      int x = Integer.parseInt(br.readLine());

      if (x != 0) {
        pq.add(x);
        continue;
      }

      sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
    }
    System.out.println(sb.toString());
  }
}