import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; // 각 계단에서의 누적 점수의 최댓값
        dp[0] = 0;

        int[] score = new int[N + 1];

        for (int i = 1; i <= N; i++) { // 각 계단의 점수
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = score[1];
        if (N >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= N; i++) {
            // 바로 전 계단, 전전 계단 경우로 나눔
            dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);


        }
        System.out.println(dp[N]);

    }
}
