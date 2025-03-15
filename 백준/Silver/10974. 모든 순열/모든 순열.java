import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int N;
	static int[] arr;
	static boolean[] check;
	static List<Integer> list = new ArrayList<>();;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1 ; i <= N ; i++) {
			list.add(i);
		}
		
		arr = new int[N];
		check = new boolean[N];
		
		permutation(0);

	}
	
	private static void permutation(int idx) {
		// 종료조건
		if (idx == N) {
			for (int i : arr) {
				System.out.print(i + " ");
			} System.out.println();
		}
		
		// 재귀조건
		for (int i = 0 ; i < N ; i++) {
			
			if (check[i]) continue;
				arr[idx] = list.get(i);
				check[i] = true;
				permutation(idx+1);
				check[i] = false;
		}
	}
}
