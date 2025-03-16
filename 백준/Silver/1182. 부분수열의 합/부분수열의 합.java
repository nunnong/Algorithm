import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 부분수열 중 그 수열의 원소를 다 더한 값이 S가 되도록 하는 경우의 수
	
	static int N;
	static int S;
	static int[] list;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().trim().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		S = Integer.parseInt(tmp[1]);
		
		
		list = new int[N];
		String[] tmp2 = br.readLine().trim().split(" ");
		for (int i = 0 ; i < N ; i++) {
			list[i] = Integer.parseInt(tmp2[i]);
		}
		
		count = 0;
		partSum(0, 0);
		
		// 공집합 제외
		if (S == 0) {
			count--;
		}
		
		System.out.println(count);
		
	}
	
	private static void partSum(int depth, int sum) { // sum은 뽑은 수들의 합
		// 종료 조건
		if (depth == N) {
			if (sum == S) {
				count++;
			}
			return;
		}
		
		// 재귀 조건
		partSum(depth + 1, sum + list[depth]);
		partSum(depth + 1, sum);
		
	}
}
