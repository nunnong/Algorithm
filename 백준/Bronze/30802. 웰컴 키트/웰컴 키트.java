import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int shirts = 0;
    int[] arr = new int[6];

    for (int i = 0; i < 6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    for (int i = 0; i < 6; i++) {
      shirts += Math.ceil(arr[i] / (double) T);
    }

    int penGroup = N / P;
    int penSingle = N % P;

    System.out.println(shirts);
    System.out.println(penGroup + " " + penSingle);
  }
}
