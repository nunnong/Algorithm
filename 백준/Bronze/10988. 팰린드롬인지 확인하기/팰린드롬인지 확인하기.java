import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine();
    StringBuilder sb = new StringBuilder(word).reverse();

    System.out.println((word.equals(sb.toString()) ? 1 : 0));
  }
}