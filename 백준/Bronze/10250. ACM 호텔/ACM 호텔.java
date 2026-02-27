import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int H = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      int floor;
      int room;

      if (N % H == 0) {
        floor = H;
        room = N / H;
      } else {
        floor = N % H;
        room = N / H + 1;
      }

      sb.append(floor);

      if (room < 10) {
        sb.append(0);
      }
      sb.append(room).append("\n");
    }

    System.out.println(sb);
  }
}