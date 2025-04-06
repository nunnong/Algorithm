import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, minDiffer;
	static int[] arr, data;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		data = new int[3];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		minDiffer = M;
		combination(0, 0);

		System.out.println(M - minDiffer);

	}

	private static void combination(int idx, int start) {
		// TODO Auto-generated method stub

		if (idx == 3) {
			int sum = 0;

			for (int i : data) {
				sum += i;
			}
			
			if (sum == M) {
				minDiffer = 0;
				return;
			}

			if (sum <= M && minDiffer > M - sum) {
				minDiffer = M - sum;
			}

			return;
		}

		for (int i = start; i < N; i++) {

			data[idx] = arr[i];

			combination(idx + 1, i + 1);
		}
	}

}
