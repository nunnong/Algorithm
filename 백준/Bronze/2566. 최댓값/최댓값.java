import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int[][] table = new int[9][9];
    int max = 0;
    int maxRow = 0;
    int maxCol = 0;

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        table[i][j] = Integer.parseInt(st.nextToken());
        if (max < table[i][j]) {
          max = table[i][j];
          maxRow = i;
          maxCol = j;
        }
      }
    }
    sb.append(max).append("\n").append(maxRow + 1).append(" ").append(maxCol + 1);
    System.out.println(sb.toString());

  }
}
