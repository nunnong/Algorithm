import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int[][] map;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // N, M
            String[] tmp = br.readLine().trim().split(" ");
            int N = Integer.parseInt(tmp[0]);
            int M = Integer.parseInt(tmp[1]);

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            int maxSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    maxSum = Math.max(maxSum, pangSum(i, j, N, M));
                }
            }

            System.out.println("#" + tc + " " + maxSum);

        }
    }
        static int pangSum ( int currentX, int currentY, int N, int M){
            int value = map[currentX][currentY];

            for (int dir = 0; dir < 4; dir++) { // direction
                for (int i = 1 ; i <= map[currentX][currentY]; i++) {
                    int nx = currentX + dx[dir] * i;
                    int ny = currentY + dy[dir] * i;

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        value += map[nx][ny];
                    }
                }

            }

            return value;

        }
    }
