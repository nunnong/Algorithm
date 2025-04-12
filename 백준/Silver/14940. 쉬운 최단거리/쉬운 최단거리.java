import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int startX, startY;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					visited[i][j] = true;
				}
				if (map[i][j] == 2) {
					visited[i][j] = true;
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY, 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (!visited[i][j]) {
					map[i][j] = -1;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}
	}

	private static void bfs(int x, int y, int depth) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, depth });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			x = tmp[0];
			y = tmp[1];
			depth = tmp[2];

			map[x][y] = depth;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny, depth + 1 });
				}
			}

		}

	}
}
