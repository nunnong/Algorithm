import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] scores = new int[P];
        int size = 0;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && size < P) {
                scores[size++] = Integer.parseInt(st.nextToken());
            }
        }

        int rank = 1;
        for (int i = 0; i < size; i++) {
            if (scores[i] > score) {
                rank++;
            } else if (scores[i] == score) {
                continue;
            } else {
                break;
            }
        }

        if (size == P && scores[size - 1] >= score) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
