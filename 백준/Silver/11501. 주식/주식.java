import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int days = Integer.parseInt(br.readLine());
      int[] prices = new int[days];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < days; i++) {
        prices[i] = Integer.parseInt(st.nextToken());
      }

      long profit = 0;
      int start = 0;

      while (start < days) {

        // 1. 현재 구간의 최대값 찾기
        int maxIdx = start;
        for (int i = start; i < days; i++) {
          if (prices[i] >= prices[maxIdx]) {
            maxIdx = i;
          }
        }

        // 2. 자기 자신이 최대면 그냥 넘어감
        if (maxIdx == start) {
          start++;
          continue;
        }

        // 3. start ~ maxIdx 전까지 전부 매수
        for (int i = start; i < maxIdx; i++) {
          profit += prices[maxIdx] - prices[i];
        }

        // 4. 다음 구간 시작
        start = maxIdx + 1;
      }

      sb.append(profit).append("\n");
    }

    System.out.print(sb);
  }
}