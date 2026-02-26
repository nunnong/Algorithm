import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> names = new HashMap<>();
    List<String> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      names.put(br.readLine(), 1);
    }

    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      names.put(name, names.getOrDefault(name, 0) + 1);

      if (names.get(name) == 2) {
        list.add(name);
      }
    }

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    sb.append(list.size());

    for (String str : list) {
      sb.append("\n");
      sb.append(str);
    }

    System.out.println(sb.toString());
  }
}
