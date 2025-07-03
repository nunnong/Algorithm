import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] line;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        int maxLength = 0;

        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, line[i]);
        }

        long left = 1;
        long right = maxLength;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0; // 랜선의 개수
            for (int i = 0; i < K; i++) {
                cnt += line[i] / mid;
            }

            if (cnt >= N) {
                ans = mid;
                left = mid + 1;
            } else if (cnt < N) {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
