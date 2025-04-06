import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			BigInteger data = new BigInteger(String.valueOf(a));
			BigInteger result = data.modPow(BigInteger.valueOf(b), BigInteger.TEN); // a^b % 10

			int ans = result.intValue();
			
			// 출력이 0이면 실제로는 10번 컴퓨터가 계산한 것이므로 10으로 처리
			if (ans == 0) {
				System.out.println(10);
			} else {
				System.out.println(ans);
			}
		}
	}
}
