import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static boolean[] visited;
  static int[] rowArr;
  static int N, ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    visited = new boolean[N + 1];
    rowArr = new int[N + 1];
     
    if (N == 1) {
      ans = 1;
    } else {
      find(1, 0);
    }
    System.out.println(ans);

  }

  static void find(int row, int pre) {
    if (row == N + 1) {
      ans++;
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        rowArr[row] = i;

        if (check(row, i)) {
          find(row + 1, i);
        }
        visited[i] = false;
      }
    }
  }

  static boolean check(int row, int col) {

    if (row == 1) {
      return true;
    }
    for (int i = 1; i < row; i++) {
      int row1 = i;
      int col1 = rowArr[i];

      if (Math.abs(row1 - row) == Math.abs(col1 - col)) {
        return false;
      }
    }
    return true;
  }
}