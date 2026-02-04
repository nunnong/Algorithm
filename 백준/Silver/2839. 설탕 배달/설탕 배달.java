import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int fiveCnt = N / 5;
    boolean carriable = false;
    int min = 0;

    for (int i = fiveCnt; i >= 0; i--) {
      int rest = N - i * 5;
      if (rest % 3 == 0) {
        carriable = true;
        min = i + rest / 3;
        break;
      }
    }
    System.out.println(carriable ? min : -1);
  }
}
