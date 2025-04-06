import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[][] farm;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }

            System.out.println("#" + tc + " " + harvest());
        }
    }

    private static int harvest() {
        int sum = 0;
        int mid = N / 2; // 어차피 mid가 정수형이니까 그냥 나눠줘도 되겠네!

        for (int i = 0; i < N; i++) {
            int start = Math.abs(mid - i); 
            int end = N - start;

            for (int j = start; j < end; j++) {
                sum += farm[i][j];
            }
        }

        return sum;
    }
}
