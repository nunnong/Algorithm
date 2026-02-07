import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> q = new ArrayDeque<>();

    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);

    int[] num = new int[N];

    for (int i = 0; i < N; i++) {
      num[i] = i + 1;
    }
    boolean[] checked = new boolean[N];

    int idx = 0;
    int n = N;
    while (n-- > 0) {
      int cnt = 0;

      while (cnt < K) {
        if (checked[idx]) {
          idx = (idx + 1) % N;
          continue;
        } else {
          cnt++;
          if (cnt == K) {
            checked[idx] = true;
            q.add(num[idx]);
          }
          idx = (idx + 1) % N;
        }
      }
    }
    String ans = q.toString().replace('[', '<').replace(']', '>');
    System.out.println(ans);

  }
}
