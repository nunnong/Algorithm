import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited = new boolean[101][101];
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            cntArea(x1, y1, x2, y2);
        }

        System.out.println(count);

    }

    private static void cntArea(int x1, int y1, int x2, int y2) {

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (!visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                }
            }
        }

    }
}
