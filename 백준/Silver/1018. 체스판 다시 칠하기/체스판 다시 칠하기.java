import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                map[i][j] = (c == 'W') ? 1 : 0;
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                counting(i, j);
            }
        }

        System.out.println(count);
    }

    private static void counting(int n, int m) {

        // 첫 번째 블럭이 White
        int cntWhite = 0;

        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if ((i + j) % 2 == 0 && map[i][j] == 0) {
                    cntWhite++;
                }
                if ((i + j) % 2 == 1 && map[i][j] == 1) {
                    cntWhite++;
                }
            }
        }

        // 첫 번째 블럭이 Black

        int cntBlack = 0;

        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if ((i + j) % 2 == 0 && map[i][j] == 1) {
                    cntBlack++;
                }
                if ((i + j) % 2 == 1 && map[i][j] == 0) {
                    cntBlack++;
                }
            }
        }

        count = Math.min(count, Math.min(cntWhite, cntBlack));


    }


}
