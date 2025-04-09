import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    static int[] data;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 중복 순열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개 중
        M = Integer.parseInt(st.nextToken()); // M개 뽑기
        arr = new int[N];
        data = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permutation(0);
        System.out.println(sb);

    }

    private static void permutation(int idx) {
        if (idx == M) {
            for (int i : data) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0 ; i < N ; i++) {
             data[idx] = arr[i];
             permutation(idx+1);
        }
    }
}
