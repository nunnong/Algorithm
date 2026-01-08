import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int pay = Integer.parseInt(br.readLine());
    int changes = 1000 - pay;

    int[] coin = { 500, 100, 50, 10, 5, 1 };

    int ans = 0;

    for (int c : coin) {
      ans += changes / c;
      changes %= c;

      if (changes == 0)
        break;
    }

    System.out.println(ans);
  }
}