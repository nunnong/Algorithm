import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int num1, num2, numSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < numSum) {
                num1 = arr[left];
                num2 = arr[right];
                numSum = Math.abs(sum);
            }
            if (sum == 0) {
                num1 = arr[left];
                num2 = arr[right];
                break;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }
        System.out.println(num1 + " " + num2);
    }
}
