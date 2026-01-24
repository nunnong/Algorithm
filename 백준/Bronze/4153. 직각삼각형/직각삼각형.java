import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public interface Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = br.readLine()) != null) {

      StringTokenizer st = new StringTokenizer(line);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0)
        break;

      int[] arr = { a, b, c };
      Arrays.sort(arr);

      String answer = power(arr[2]) == power(arr[0]) + power(arr[1]) ? "right" : "wrong";

      System.out.println(answer);
    }

  }

  static int power(int x) {
    return x * x;
  }
}
