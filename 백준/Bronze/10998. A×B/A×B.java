import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");

    int A = Integer.parseInt(line[0]);
    int B = Integer.parseInt(line[1]);

    System.out.println(A * B);
  }

}
