import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    int cnt = 1;

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append("Case #").append(cnt++).append(": ").append(a + b).append("\n");
    }

    System.out.println(sb.toString());

  }
}
