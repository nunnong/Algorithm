import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int lengthCnt, max;
    static int idx = 0;
    static boolean exit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];
        int left = 0;
        int maxLength = 0;

        for (idx = 0; idx < N; idx++) {
            count[arr[idx]]++;

            while (count[arr[idx]] > K) {
                count[arr[left]]--;
                left++;
            }

            lengthCnt = idx - left + 1;
            if (maxLength < lengthCnt) {
                maxLength = lengthCnt;
            }
        }

        System.out.println(maxLength);
    }
}
