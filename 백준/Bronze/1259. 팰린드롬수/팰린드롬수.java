import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String input = br.readLine();

      if (input.equals("0"))
        break;

      String[] line = input.split("");

      StringBuilder palindrome = new StringBuilder();

      for (int i = line.length - 1; i >= 0; i--) {
        palindrome.append(line[i]);
      }

      System.out.println(input.equals(palindrome.toString()) ? "yes" : "no");
    }

  }
}
