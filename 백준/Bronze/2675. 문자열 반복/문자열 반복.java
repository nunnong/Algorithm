import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());

      int rep = Integer.parseInt(st.nextToken());
      String text = st.nextToken();

      for (int j = 0; j < text.length(); j++) {
        char c = text.charAt(j);
        for (int k = 0; k < rep; k++) {
          sb.append(c);
        }
      }

      System.out.println(sb.toString());

    }
  }

}
