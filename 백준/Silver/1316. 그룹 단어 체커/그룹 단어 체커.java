import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int groupWord = 0;

    for (int i = 0; i < n; i++) {
      char[] arr = br.readLine().toCharArray();

      boolean[] alphabet = new boolean[26];
      boolean pass = false;

      char previous = arr[0];
      alphabet[previous - '0' - 49] = true;

      if (arr.length == 1)
        groupWord++;

      for (int j = 1; j < arr.length; j++) {

        // 직전값과 같을 때
        if (previous == arr[j]) {
          pass = true;
          continue;

          // 직전값과 다르면서 이전에 등장한 적이 없음
        } else if (!alphabet[arr[j] - '0' - 49]) {
          alphabet[arr[j] - '0' - 49] = true;
          previous = arr[j];
          pass = true;
          continue;

          // 직전값과 다르면서 이전에 등장한 적이 있음
        } else if (alphabet[arr[j] - '0' - 49]) {
          pass = false;
          break;

        }

      }
      // 그룹단어 성립될 때
      if (pass) {
        groupWord++;
      }
    }

    System.out.println(groupWord);
  }
}
