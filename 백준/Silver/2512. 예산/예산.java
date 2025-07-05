import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {


        // 투 포인터
        // 상한선 구하기 (M이 N이상이니까 최소 각 1씩은 돌릴 수 있음.)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int budget = Integer.parseInt(br.readLine());

        int left = 1;
        int right = Math.min(max, budget);
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum == budget) {
                ans = mid;
                break;

            } else if (sum > budget) {
                right = mid - 1;

            } else {
                ans = mid;
                left = mid + 1;
            }

        }

        System.out.println(ans);
    }
}
