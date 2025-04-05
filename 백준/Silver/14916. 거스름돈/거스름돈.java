import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 거스름돈 동전의 최소 개수를 출력, 거슬러 줄 수 없으면 -1 출력

		int cnt = 0;
		if (n == 1 || n == 3) {
			System.out.println(-1);
			System.exit(0);
		}

		// 무조건 거슬러 줄 수 있는 구간
		while (n >= 5) {
			n -= 5;
			cnt++;
		}
		if (n % 2 != 0) {
			n = n + 5;
			cnt--;
			while (n > 0) {
				n = n - 2;
				cnt++;
			}

		} else {
			cnt += n / 2;
		}

		System.out.println(cnt);

	}

}
