import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");

    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);

    int min = (N < M) ? N : M;
    int GCD = 1;

    for (int i = min; i > 0; i--) {
      if (N % i == 0 && M % i == 0) {
        GCD = i;
        break;
      }
    }

    int LCM = N * M / GCD;
    System.out.println(GCD);
    System.out.println(LCM);
  }
}
