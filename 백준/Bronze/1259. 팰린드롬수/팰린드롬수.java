import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String input = br.readLine();

      if (input.equals("0")) break;

      StringBuilder palindrome = new StringBuilder(input);
      palindrome.reverse();

      System.out.println(input.equals(palindrome.toString()) ? "yes" : "no");
    }

  }
}
