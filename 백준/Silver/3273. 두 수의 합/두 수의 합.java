import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());
    int ans = 0;

    Arrays.sort(arr);
    int left = 0;
    int right = n - 1;

    while (left < right) {
      if (left == n || right == 0) {
        break;
      }
      int sum = arr[left] + arr[right];

      if (sum == x) {
        ans++;
        left++;
        right--;
      } else if (sum > x) {
        right--;
      } else {
        left++;
      }
    }

    System.out.println(ans);

  }
}
