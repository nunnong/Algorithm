import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int pay = sc.nextInt();
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

    sc.close();

  }
}