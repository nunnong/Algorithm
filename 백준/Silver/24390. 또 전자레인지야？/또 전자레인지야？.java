import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] s = { 10, 30, 60, 600 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().trim().split(":");

		int minute = Integer.parseInt(tmp[0]);
		int second = Integer.parseInt(tmp[1]);

		int time = 60 * minute + second;

		// 10, 30, 60, 600초
		int cnt = 1;

		if (time == 0) {
			cnt = 0;
		} else {
			cnt += time / 600;
			time %= 600;

			cnt += time / 60;
			time %= 60;

			if (time / 30 != 0) {
				cnt--;
			}
			cnt += time / 30;
			time %= 30;

			cnt += time / 10;
			time %= 10;
		}

		System.out.println(cnt);

	}

}
