import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] data;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().trim().split(" ");

        N = Integer.parseInt(tmp[0]); // N개 중에서
        M = Integer.parseInt(tmp[1]); // M개를 골라
        data = new int[M];
        visited = new boolean[N];
        permutation(0);
    }

    private static void permutation(int idx) {
        if (idx == M) {
            for (int i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1 ; i <= N ; i++) {
            if (!visited[i-1]) {
                data[idx] = i;
                visited[i-1] = true;
                permutation(idx+1);
                visited[i-1] = false;
            }

        }
    }
}
