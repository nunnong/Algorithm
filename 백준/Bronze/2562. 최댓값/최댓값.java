import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[10];
    int maxIdx = 0;
    int maxValue = 0;

    for (int i = 1; i <= 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());

      if (maxValue < arr[i]) {
        maxValue = arr[i];
        maxIdx = i;
      }
    }

    System.out.println(maxValue);
    System.out.println(maxIdx);
  }

}
