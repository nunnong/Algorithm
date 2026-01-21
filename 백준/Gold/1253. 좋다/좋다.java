import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    boolean[] isGood = new boolean[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    for (int i = 0; i < N; i++) {
      int sum = arr[i];

      int left = 0;
      int right = N - 1;

      while (left < right) {

        if (arr[left] + arr[right] == sum) {
          if (i != left && i != right) {
            isGood[i] = true;
            break;
          } else if (i == left) {
            left++;
            continue;
          } else {
            right--;
            continue;
          }
        } else if (arr[left] + arr[right] > sum) {
          right--;
        } else {
          left++;
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if (isGood[i]) {
        cnt++;
      }
    }

    System.out.println(cnt);

  }
}