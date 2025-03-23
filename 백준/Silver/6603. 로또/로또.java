import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int K;
    static int[] subset;
    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 입력
        while (true) {
            String[] tmp = br.readLine().trim().split(" ");

            K = Integer.parseInt(tmp[0]);
            if (K == 0) break;

            subset = new int[tmp.length-1];
            Arrays.sort(subset);

            for (int i = 1 ; i < tmp.length; i++) {
                subset[i-1] = Integer.parseInt(tmp[i]);
            }

            // 출력
            lottery(0, 0);
            System.out.println();
        }
    }

    // 로직
    // 조합을 이용해서 kC6하기!

    public static void lottery(int idx, int start) {

        if (idx == 6) { // 6개의 숫자만 뽑을 수 있음.
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start ; i < subset.length ; i++) {

            arr[idx] = subset[i];
            lottery(idx+1, i+1);

        }

    }
}
