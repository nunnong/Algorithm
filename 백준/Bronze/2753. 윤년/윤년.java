import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int year = Integer.parseInt(br.readLine());

    boolean isLeapYear = false;
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
      isLeapYear = true;
    }

    System.out.println(isLeapYear ? 1 : 0);
  }

}
