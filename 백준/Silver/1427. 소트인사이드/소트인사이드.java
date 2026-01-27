import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int[] sort = new int[str.length()];

    for (int i = 0; i < str.length(); i++) {
      sort[i] = str.charAt(i) - '0';
    }
    Arrays.sort(sort);
    StringBuilder sb = new StringBuilder();

    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(sort[i]);
    }

    System.out.println(sb.toString());
  }

}