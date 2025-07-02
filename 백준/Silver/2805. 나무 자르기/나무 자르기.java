import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int mid;
    static int[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, tree[i]);
        }
        int left = 0;
        int right = maxHeight;
        int ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.max(tree[i] - mid, 0);
            }
            if (sum > M) {
                ans = mid;
                left = mid + 1;
            } else if (sum < M) {
                right = mid - 1;
            } else {
                ans = mid;
                break;
            }
            
        }
        System.out.println(ans);
    }

}
