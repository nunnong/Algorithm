import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int[] check = new int[4];
  static Map<Character, Integer> map = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    char[] arr = new char[S];
    arr = br.readLine().toCharArray();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      check[i] = Integer.parseInt(st.nextToken());
    }
    int cnt = 0;
    int left = 0;
    int right = P - 1;

    for (int i = left; i <= right; i++) {
      check[map.get(arr[i])]--;
    }

    if (check[0] <= 0 && check[1] <= 0 && check[2] <= 0 && check[3] <= 0) {
      cnt++;
    }

    left++;
    right++;

    while (right < S) {
      // 추가된 요소(check 배열에서 빼주기)
      check[map.get(arr[right])]--;
      // 제거된 요소(check 배열에서 더해주기)
      check[map.get(arr[left - 1])]++;

      if (check[0] <= 0 && check[1] <= 0 && check[2] <= 0 && check[3] <= 0) {
        cnt++;
      }
      left++;
      right++;
    }
    System.out.println(cnt);
  }
}
