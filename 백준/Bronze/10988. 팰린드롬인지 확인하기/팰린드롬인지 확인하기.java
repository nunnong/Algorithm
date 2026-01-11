import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] arr = br.readLine().toCharArray();
    boolean isEqual = true;

    for (int i = 0; i < arr.length / 2; i++) {
      if (arr[i] != arr[arr.length - 1 - i]) {
        isEqual = false;
        break;
      }
    }

    System.out.println(isEqual ? 1 : 0);
  }
}
