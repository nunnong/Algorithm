import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int max = sum;

        for (int i = 1 ; i < n ; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum = Math.max(num, sum + num);
            max = Math.max(sum, max);
        }

        System.out.println(max);

    }
}
