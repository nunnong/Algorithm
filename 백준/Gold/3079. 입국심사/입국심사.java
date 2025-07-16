import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int rot = (M%N == 0) ? M/N : M/N+1;
        int[] arr = new int[N];
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        long minTime = (long) max * rot;

        long left = min;
        long right = minTime;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum += mid / arr[i];
                if (sum >= M) break;
            }
            if (sum >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
