import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 스타트와 링크

	static int N, differ = 100;
	static boolean[] visited;
	static int[][] powerTable;
	static int[] startTeam;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		powerTable = new int[N][N];
		startTeam = new int[N / 2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				powerTable[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		combination(0, 0);

		System.out.println(differ);

	}

	private static void combination(int idx, int start) {
		// 스타트 팀을 뽑자!
		if (idx == N / 2) {
			visited = new boolean[N];
			for (int i : startTeam) {
				visited[i] = true;
			}

			sumPower();
			return;
		}

		for (int i = start; i < N; i++) {
			startTeam[idx] = i;
			combination(idx + 1, i + 1);
		}
	}

	private static void sumPower() {

		int linkPower = 0;
		int startPower = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {

				startPower += powerTable[startTeam[i]][startTeam[j]];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i] && !visited[j] && i != j) {
					linkPower += powerTable[i][j];
				}

			}
		}

		int d = Math.abs(startPower - linkPower);
		if (differ > d) {
			differ = d;
		}

	}

}
