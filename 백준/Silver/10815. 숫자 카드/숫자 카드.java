import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 배열 A
		int N = Integer.parseInt(br.readLine());

		HashSet<String> A = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
		A.add(st.nextToken());
		}
		
		// 배열 B
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			if (A.contains(st.nextToken())) {
				System.out.print(1 + " ");

			} else {
				System.out.print(0 + " ");
			}
		}

	}

}
