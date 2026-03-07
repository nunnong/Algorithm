import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int M = Integer.parseInt(br.readLine()); // 연산 횟수
    List<Integer> list = new ArrayList<>();
    List<Integer> newList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 20; i++) {
      newList.add(i);
    }

    int num = 0;
    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      String operator = st.nextToken();

      if (!operator.equals("all") && !operator.equals("empty")) {
        num = Integer.parseInt(st.nextToken());
      }

      switch (operator) {
        case "all":
          list = new ArrayList<>(newList);

        case "add":
          if (!list.contains(num)) {
            list.add(num);
          }
          break;

        case "check":
          if (list.contains(num)) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;

        case "remove":
          if (list.contains(num)) {
            int idx = list.indexOf(num);
            list.remove(idx);
          }
          break;

        case "toggle":
          if (list.contains(num)) {
            int idx = list.indexOf(num);
            list.remove(idx);
          } else {
            list.add(num);
          }
          break;

        case "empty":
          list.clear();
          break;
      }
    }
    System.out.println(sb.toString());

  }
}
