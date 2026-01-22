import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int min = 1000000;
    int max = -1000000;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num > max) {
        max = num;
      }

      if (num < min) {
        min = num;
      }
    }

    System.out.println(min + " " + max);
  }
}
