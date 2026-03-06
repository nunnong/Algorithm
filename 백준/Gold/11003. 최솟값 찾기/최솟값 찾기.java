import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    Deque<Integer> deque = new ArrayDeque<>(); // 인덱스 저장

    for (int i = 0; i < N; i++) {
      while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
        deque.pollLast();
      }
      deque.addLast(i);

      if (deque.peekFirst() <= i - L) {
        deque.pollFirst();
      }
      sb.append(arr[deque.peekFirst()]).append(" ");
    }

    System.out.print(sb);
  }
}