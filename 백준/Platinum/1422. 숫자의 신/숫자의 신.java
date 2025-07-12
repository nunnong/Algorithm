import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        int max = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = String.valueOf(num);
            max = Math.max(num, max);
        }

        String maxStr = String.valueOf(max);
        for (int i = K; i < N; i++) {
            arr[i] = maxStr;
        }

        // a+b와 b+a를 비교하여 더 큰 값을 만드는 순서로 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}