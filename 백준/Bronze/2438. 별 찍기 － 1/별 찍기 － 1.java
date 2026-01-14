import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 1; i <= N; i++) {
      sb.append("*".repeat(i)).append("\n");
    }

    System.out.println(sb.toString());
  }
}
