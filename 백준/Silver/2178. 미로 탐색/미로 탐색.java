import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().trim().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		cnt = 0;
		bfs(0, 0, 1);

		System.out.println(cnt);

	}

	private static void bfs(int x, int y, int depth) {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { x, y, depth });

		while (!q.isEmpty()) {

			int[] tmp = q.poll();

			x = tmp[0];
			y = tmp[1];
			depth = tmp[2];
			
			if (x == N-1 && y == M-1) {
				break;
			}

			for (int d = 0; d < 4; d++) {

				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny, depth + 1 });
				}
			}

		}
		cnt = depth;

	}

}
