import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int M = Integer.parseInt(br.readLine());
    boolean[] set = new boolean[21];
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      String operator = st.nextToken();

      int num = 0;
      if (!operator.equals("all") && !operator.equals("empty")) {
        num = Integer.parseInt(st.nextToken());
      }

      switch (operator) {
        case "all":
          Arrays.fill(set, 1, 21, true);
          break;

        case "empty":
          Arrays.fill(set, 1, 21, false);
          break;

        case "add":
          set[num] = true;
          break;

        case "remove":
          set[num] = false;
          break;

        case "check":
          sb.append(set[num] ? 1 : 0).append("\n");
          break;

        case "toggle":
          set[num] = !set[num];
          break;
      }
    }
    System.out.print(sb);
  }
}