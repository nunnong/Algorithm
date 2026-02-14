import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static List<Integer>[] arr;
  static Queue<Integer> q;
  static StringBuilder sb = new StringBuilder();
  static boolean[] checked;
  static boolean[] bfsChecked;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N + 1];

    for (int i = 0; i <= N; i++) {
      arr[i] = new ArrayList<Integer>();
    }

    q = new ArrayDeque<>();
    checked = new boolean[N + 1];
    bfsChecked = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      arr[n1].add(n2);
      arr[n2].add(n1);
    }
    for (int i = 1; i <= N; i++) {
      Collections.sort(arr[i]);
    }

    DFS(V);
    sb.append("\n");
    BFS(V);

    System.out.println(sb.toString());

  }

  static void DFS(int node) {
    checked[node] = true;
    sb.append(node).append(" ");

    for (int i : arr[node]) {
      if (!checked[i]) {
        DFS(i);
      }
    }
  }

  static void BFS(int node) {
    q.add(node);
    bfsChecked[node] = true;
    sb.append(node).append(" ");

    while (!q.isEmpty()) {
      int n = q.poll();
      for (int i : arr[n]) {
        if (!bfsChecked[i]) {
          bfsChecked[i] = true;
          sb.append(i).append(" ");
          q.add(i);
        }
      }
    }
  }

}
