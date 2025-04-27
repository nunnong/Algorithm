import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static int[][] avg;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		avg = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int r = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				avg[i][j] = (r + g + b) / 3;
			}
		}

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (avg[i][j] >= T && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int cx = tmp[0];
			int cy = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && avg[nx][ny] >= T && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}
