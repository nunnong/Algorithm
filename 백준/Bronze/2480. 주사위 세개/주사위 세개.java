import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[7];

    for (int i = 0; i < 3; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[num]++;
    }

    int max = 0;
    int maxIdx = 0;

    for (int i = 1; i <= 6; i++) {
      if (max <= arr[i]) {
        max = arr[i];
        maxIdx = i;
      }
    }

    int ans = 0;
    switch (max) {
      case 1:
        ans = maxIdx * 100;
        break;
      case 2:
        ans = 1000 + maxIdx * 100;
        break;
      case 3:
        ans = 10000 + maxIdx * 1000;
        break;
    }

    System.out.println(ans);

  }
}
