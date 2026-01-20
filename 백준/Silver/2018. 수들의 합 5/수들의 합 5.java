import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int start = 1;
    int end = 1;

    int cnt = 1;
    int sum = start;

    while (end != N) {
      if (sum == N) {
        cnt++;
        end++;
        sum = sum + end - start;
        start++;
      } else if (sum > N) {
        sum -= start;
        start++;
      } else {
        end++;
        sum += end;
      }
    }
    sc.close();
    System.out.println(cnt);
  }
}
