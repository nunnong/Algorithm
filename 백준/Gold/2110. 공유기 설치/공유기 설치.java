import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] houses;
    static int N, C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int left = 1;
        int right = houses[N-1] - houses[0];
        int ans = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);

    }

    private static boolean canInstall(int mid) {
        // mid 간격으로 C번 설치 가능? -> return true

        int cnt = 1;
        int position = houses[0];

        for (int i = 1; i < N; i++) {
            if (houses[i] - position >= mid) {
                cnt++;
                position = houses[i];

                if (cnt >= C) {
                    return true;
                }
            }
        }
        return false;
    }
}
